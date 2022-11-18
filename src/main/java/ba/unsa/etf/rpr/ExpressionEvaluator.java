package ba.unsa.etf.rpr;

import java.util.Stack;

/**
 * The type Expression evaluator.
 */
public class ExpressionEvaluator {
    /**
     * @param s an arbitrary string
     * @return boolean value true if string is a number
     */
    private static boolean DaLiJeBroj(String s) {
        try {
            double d = Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * Evaluate double.
     * @param unos expression as a string
     * @return the evaluation of the expression
     */
    public static Double evaluate(String unos) {
        Stack<String> znakovi = new Stack<>();
        Stack<Double> vrijednosti = new Stack<>();
        int brO = 0, brZ = 0, brS = 0;
        String[] niz = unos.split(" ");
        if (!niz[0].equalsIgnoreCase("(") || unos.contains("  ")) throw new RuntimeException("Nevalidan izraz!");
        for (String c : niz) {
            if (!c.equalsIgnoreCase("sqrt") && !DaLiJeBroj(c) && c.length() != 1)
                throw new RuntimeException("Nevalidan izraz!");
            else if (c.equals("(")) brO++;
            else if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/"))
                znakovi.push(c);
            else if(c.equals("sqrt")){
                znakovi.push(c);
                brS++;
            }
            else if (c.equals(")")) {
                brZ++;
                if (znakovi.empty() || vrijednosti.empty() || znakovi.size() - brS >= vrijednosti.size())
                    throw new RuntimeException("Nevalidan izraz!");
                String z = znakovi.pop();
                double v = vrijednosti.pop();
                if (z.equals("+")) v = vrijednosti.pop() + v;
                else if (z.equals("-")) v = vrijednosti.pop() - v;
                else if (z.equals("*")) v = vrijednosti.pop() * v;
                else if (z.equals("/")) {
                    if(v == 0) throw new RuntimeException("Nevalidan izraz!");
                    v = vrijednosti.pop() / v;
                }
                else if (z.equals("sqrt")) v = Math.sqrt(v);
                vrijednosti.push(v);
            } else vrijednosti.push(Double.parseDouble(c));
        }
        if (brO != brZ || !znakovi.empty() || vrijednosti.size() != 1) throw new RuntimeException("Nevalidan izraz!");
        return vrijednosti.pop();
    }
}
