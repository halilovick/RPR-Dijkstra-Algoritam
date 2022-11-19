package ba.unsa.etf.rpr;

import java.util.Arrays;

/**
 * The type App, defines entry point of application.
 */
public class App {

    /**
     * The entry point of application.
     * @param args the input arguments from the terminal
     */
    public static void main(String[] args) {
        if (args.length != 0) {
            String s = "";
            for (String i : args)
                s = s + i + " ";
            try {
                System.out.println(ExpressionEvaluator.evaluate(s));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else{
            String s = "( 1 + 2 )";
            try {
                System.out.println(ExpressionEvaluator.evaluate(s));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}