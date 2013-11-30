package compilador;

import compilador.lex.Lexer;
import compilador.lex.Token;
import compilador.symbol.TabelaDeSimbolos;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author tulio
 */
public class Compilador {

    public static final String EOF = "65535"; // end of file code

    private Lexer lexer;

    private TabelaDeSimbolos symbols;

    public Compilador(FileReader file) {
        this.symbols = new TabelaDeSimbolos();
        this.lexer = new Lexer(file, this.symbols);
    }
    
    public void compile() throws IOException {
        // start with first token
        Token t = lexer.scan();
        System.out.println("Lexemas: ");
        while(!t.toString().equals(EOF)) {
            System.out.print("{"+t+"} ");
            t = lexer.scan();
        }

        System.out.println("\n\nErros léxicos:");
        lexer.printErrors();
        
        System.out.println("\n\nTabela de símbolos:");
        System.out.println(this.symbols.toString());
    }

}
