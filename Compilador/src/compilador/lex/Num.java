/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.lex;

/**
 *
 * @author mrz
 */
public class Num extends Token {
   
    public final float value;

    public Num(float value){
        super(Tag.NUM);
        this.value = value;
    }

    @Override
    public String toString(){
        return "" + this.value;
    }
}
