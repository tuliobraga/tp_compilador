/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.lex;

import java.util.Objects;

/**
 *
 * @author mrz
 */
public class Word extends Token {
    
    public static final Word and = new Word ("&&", Tag.AND);
    public static final Word or = new Word ("||", Tag.OR);
    public static final Word eq = new Word ("==", Tag.EQ);
    public static final Word ne = new Word ("!=", Tag.NE);
    public static final Word le = new Word ("<=", Tag.LE);
    public static final Word ge = new Word (">=", Tag.GE);
    public static final Word not = new Word ("!", Tag.NOT);
    public static final Word program = new Word ("program", Tag.PROGRAM);
    public static final Word begin = new Word ("begin", Tag.BEGIN);
    public static final Word declare = new Word ("declare", Tag.DECLARE);
    public static final Word end = new Word ("end", Tag.END);
    public static final Word integer = new Word ("int", Tag.INT);
    public static final Word character = new Word ("char", Tag.CHAR);
    public static final Word se = new Word ("if", Tag.IF);
    public static final Word entao = new Word ("then", Tag.THEN);
    public static final Word senao = new Word ("else", Tag.ELSE);
    public static final Word enquanto = new Word ("while", Tag.WHILE);
    public static final Word faca = new Word ("do", Tag.DO);
    public static final Word in = new Word ("in", Tag.IN);    
    public static final Word out = new Word ("out", Tag.OUT);
    public static final Word repeat = new Word ("repeat", Tag.REPEAT);
    public static final Word until = new Word ("until", Tag.UNTIL);
    public static final Word underline = new Word ("underline", Tag.UNDERLINE);
    public static final Word quote = new Word ("\"", Tag.QUOTE);
    public static final Word single_quote = new Word ("'", Tag.SINGLE_QUOTE);
    public static final Word bracket_right = new Word (")", Tag.BRACKET_RIGHT);
    public static final Word bracket_left = new Word ("(", Tag.BRACKET_LEFT);
    public static final Word greater = new Word (">", Tag.GREATER);
    public static final Word less = new Word ("<", Tag.LESS);
    public static final Word plus = new Word ("+", Tag.PLUS);
    public static final Word minus = new Word ("-", Tag.MINUS);
    public static final Word dot = new Word (".", Tag.DOT);
    public static final Word comma = new Word (",", Tag.COMMA);
    public static final Word semicolon = new Word (";", Tag.SEMICOLON);
    public static final Word colon = new Word (":", Tag.COLON);
    public static final Word assign = new Word ("=", Tag.ASSIGN);
    public static final Word mul = new Word ("*", Tag.MUL);
    public static final Word div = new Word ("/", Tag.DIV);

    private String lexeme = "";
    
    public Word (String s, int tag){
        super (tag);
        this.lexeme = s;
    }
    
    @Override
    public String toString(){
        return this.lexeme;
    }
    
    public String getLexeme(){
        return this.lexeme;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.lexeme);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Word other = (Word) obj;
        if (!Objects.equals(this.lexeme, other.lexeme)) {
            return false;
        }
        return true;
    }
    
}