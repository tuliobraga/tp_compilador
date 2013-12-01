package compilador.lex;

/**
 *
 * @author tulio
 */
public class Tag {
    
    public final static int

    //Palavras reservadas
    PROGRAM = 256,
    DECLARE = 257,
    BEGIN = 258,
    END = 259,
    INT = 260,
    FLOAT = 261,
    CHAR = 262,
    IF = 263,
    THEN = 264,
    ELSE = 265,
    WHILE = 266,
    DO = 267,
    IN = 268,
    OUT = 269,
    REPEAT = 270,
    UNTIL = 271,
    

    //Operadores e pontuação
    OR = 285, // ou
    AND = 286, // e
    NOT = 287, // não
    EQ = 288, // igual
    GE = 289, // maior ou igual
    LE = 290, // menor ou igual
    NE = 291, // diferente
    GREATER = 292, // maior
    LESS = 293, // menor
    PLUS = 294, // mais
    MINUS = 295, // menos
    DOT = 296, // ponto
    COMMA = 297, // vírgula
    SEMICOLON = 298, // ponto e vírgula
    COLON = 299, // dois pontos
    ASSIGN = 300, // atribuição
    MUL = 301, // multiplicação
    DIV = 302, // divisão



    //Outros tokens
    NUM = 318,
    ID = 319,
    UNDERLINE = 320,
    QUOTE = 321, // aspas duplas
    SINGLE_QUOTE = 322, // aspas simples
    BRACKET_LEFT = 323, // parenteses direita
    BRACKET_RIGHT = 324, // parenteses esquerda
    CHAR_CONST = 325, // char
    LITERAL = 326; // strings

}