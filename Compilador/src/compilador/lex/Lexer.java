/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.lex;
import compilador.symbol.Id;
import compilador.symbol.TabelaDeSimbolos;
import java.io.*;
import java.util.*;

/**
 *
 * @author mrz
 */
public class Lexer {
    
    /**
     * Contador de linhas.
     */
    private static int line = 1;

    /**
     * Caractere lido do arquivo.
     */
    private char ch = ' ';

    /**
     * Arquivo com o código fonte.
     */
    private FileReader file;

    /**
     * Words encontradas.
     */
    private HashMap words = new HashMap();
    
    private ArrayList<String> errors = new ArrayList<String>();
    
    private TabelaDeSimbolos symbols;
    
    /**
     * Método para inserir palavras reservadas na HashTable
     * 
     * @param w Word
     */
    private void reserve(Word w){
        // lexema é a chave para entrada na HashTable
        words.put(w.getLexeme(), w);
    }
    
    /**
     * Construtor
     * 
     * @param file FileReader
     */
    public Lexer(FileReader file, TabelaDeSimbolos symbols) {
        this.file    = file;
        this.symbols = symbols;

        //Insere palavras reservadas na HashTable
        reserve(new Word("if",Tag.IF));
        reserve(new Word("program",Tag.PROGRAM));
        reserve(new Word("begin",Tag.BEGIN));
        reserve(new Word("end",Tag.END));
        //reserve(new Word("type",Tag.TYPE));
        reserve(new Word("int",Tag.INT));
        reserve(new Word("declare",Tag.DECLARE));
        reserve(new Word("float",Tag.FLOAT));
        reserve(new Word("char",Tag.CHAR));
        reserve(new Word("then",Tag.THEN));
        reserve(new Word("else",Tag.ELSE));
        reserve(new Word("while",Tag.WHILE));
        reserve(new Word("do",Tag.DO));
        reserve(new Word("in",Tag.IN));
        reserve(new Word("out",Tag.OUT));
        reserve(new Word("repeat",Tag.REPEAT));
        reserve(new Word("until",Tag.UNTIL));
    }
    
    /**
     * Lê o próximo caractere do arquivo.
     * 
     * @throws IOException 
     */
    private void readch() throws IOException{
        ch = (char) file.read();
    }
    
    /* Lê o próximo caractere do arquivo e verifica se é igual a c*/
    private boolean readch(char c) throws IOException{
        readch();
        if (ch != c) return false;
        ch = ' ';
        return true;
    }
    
    /**
     * 
     * 
     * @return Token
     * 
     * @throws IOException 
     */
    public Token scan() throws IOException{
        //Desconsidera delimitadores na entrada
        for (;; readch()) {
            if (ch == ' ' || ch == '\t' || ch == '\r' || ch == '\b') continue;
            else if (ch == '\n') line++; //conta linhas
            else break;
        }

        switch(ch){
            //Operadores e pontuação
            case '&':
                if (readch('&')) return Word.and;
                else return new Token('&');
            case '|':
                if (readch('|')) return Word.or;
                else return new Token('|');
            case '=':
                if (readch('=')) return Word.eq;
                else return Word.assign;
            case '<':
                if (readch('=')) return Word.le;
                else return Word.less;
            case '>':
                if (readch('=')) return Word.ge;
                else return Word.greater;
            case '!':
                if (readch('=')) return Word.ne;
                else return Word.not;
            case '+':
                readch();
                return Word.plus;
            case '-':
                readch();
                return Word.minus;
            case '.':
                readch();
                return Word.dot;
            case ',':
                readch();
                return Word.comma;
            case ';':
                readch();
                return Word.semicolon;
            case ':':
                readch();
                return Word.colon;
            case '*':
                readch();
                return Word.mul;
            case '/':
                readch();
                return Word.div;                
            case '(':
                readch();
                return Word.bracket_left;
            case ')':
                readch();
                return Word.bracket_right;
            case '\"':
                readch();
                return Word.quote;
            case '\'':
                readch();
                return Word.single_quote;
        }
        
        // Números
        boolean jaTemPonto = false;
        boolean lastCharIsDot = false;
        if (Character.isDigit(ch)){
            int value=0;
            do {
                if(jaTemPonto) {
                    this.errors.add("\nERROR at line "+this.line+": unexpected caracter `.`. A second `.` char was found in the same float value.");
                }

                if(ch == '.') {
                    jaTemPonto = true;
                    lastCharIsDot = true;
                } else {
                    lastCharIsDot = false;
                }

                value = 10*value + Character.digit(ch,10);
                readch();
                if(!Character.isDigit(ch) && !Character.isSpaceChar(ch) && lastCharIsDot) {
                    this.errors.add("\nERROR at line "+this.line+": unexpected caracter `"+ch+"`. A digit was not found after a dot in the float value.");
                }
            } while (Character.isDigit(ch) || ch == '.');

            return new Num(value);
        }
        
        // Identificadores
        if (Character.isLetter(ch)){
            StringBuilder sb = new StringBuilder();
            do {
                sb.append(ch);
                readch();
            } while (Character.isLetterOrDigit(ch) || ch == '_');

            if(Character.isSpace(ch) == false && ch != (char)-1) {
                this.errors.add("\nERROR at line "+this.line+": unexpected caracter `"+ch+"`. Malformed identifier.");
            }

            String s = sb.toString();
            Word w = (Word) words.get(s);

            //palavra já existe no HashMap
            if (w != null) return w;
            
            w = new Word(s, Tag.ID);
            words.put(s, w);
            
            // adiciona identificador na tabela de símbolos, se ainda não existir
            if (!symbols.has(w)) {
                symbols.put(w, new Id(w.getLexeme()));
            }
            
            return w;
        }

        //Caracteres não especificados
        Token t = new Token(ch);
        ch = ' ';
        return t;
    }

    public void printErrors() {
        for(String error: this.errors) {
            System.out.println(error);
        }
    }

    

}