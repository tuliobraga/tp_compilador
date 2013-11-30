package compilador.symbol;

import compilador.lex.Token;
import java.util.*;

/**
 *
 * @author mrz
 */
public class TabelaDeSimbolos {

    /**
     * Tabela de símbolos do ambiente.
     */
    private HashMap<Token, Id> table;

    /**
     * Ambiente imediatamente superior.
     */
    protected TabelaDeSimbolos prev;
    
    /**
     * 
     * @param n 
     */
    public TabelaDeSimbolos(){
        // cria a TS para o ambiente
        this.table = new HashMap();
        this.prev = null;
    }

    /**
     * 
     * @param n 
     */
    public TabelaDeSimbolos(TabelaDeSimbolos n){
        // cria a TS para o ambiente
        this.table = new HashMap();

        // associa o ambiente atual ao anterior
        this.prev = n;
    }

    /**
     * Insere uma entrada na TS do ambiente.
     * 
     * @param w Token devolvido pelo analisador léxico.
     * @param i Identificador a ser adicionado na tabela de símbolos.
     */
    public void put(Token w, Id i){
        this.table.put(w, i); 
    }

    /**
     * Este método retorna as informações (Id) referentes a determinado Token.
     * 
     * @param w Token a ser pesquisado do ambiente atual para os anteriores.
     * @return 
     */
    public Id get(Token w){
        return table.get(w);
    }
    
    public boolean has(Token w) {
        return table.containsKey(w);
    }

    @Override
    public String toString() {
        String symbols = "";
        for (Token t : table.keySet()) {
            Id id = table.get(t);
            symbols += t + " -> " + id.toString() + "\n";
        }
        return symbols;
    }
    
}
