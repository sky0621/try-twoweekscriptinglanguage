package chap3;

import stone.CodeDialog;
import stone.Lexer;
import stone.ParseException;
import stone.Token;

/**
 * Created by SS on 2017/10/16.
 */
public class LexerRunner {
    public static void main(String[] args) throws ParseException {
        Lexer l = new Lexer(new CodeDialog());
        for (Token t; (t = l.read()) != Token.EOF; ) {
            System.out.println("=> " + t.getText());
        }
    }
}
