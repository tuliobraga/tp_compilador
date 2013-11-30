/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author frederico
 */
public class Loader {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String filename = "";
        try{
            filename = args[0];
            String filepath = "./extra/" + filename;

            // load file
            FileReader file = new FileReader(filepath);
            
            new Compilador(file).compile();
        } catch(FileNotFoundException e){
            System.out.println("Arquivo "+filename+" não encontrado");
        } catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        } catch(ArrayIndexOutOfBoundsException aie) {
            System.out.println("Erro ao compilar: Nenhum arquivo de códigos-fonte foi passado como parâmetro.");
        }
    }
    
}
