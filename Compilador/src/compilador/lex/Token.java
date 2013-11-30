/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.lex;

/**
 *
 * @author mrz
 */
public class Token {

    /**
     * Constante que representa o token.
     */
    public final int tag;

    public Token (int t){
        tag = t;
    }

    @Override
    public String toString(){
        return "" + tag;
    }

}
