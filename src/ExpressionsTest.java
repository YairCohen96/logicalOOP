// Yair Cohen
import java.util.Map;
import java.util.TreeMap;

/**
 * Class for testing actions done on logical expression.
 * The class initialises a new expression and values map for it and then:
 * prints the original expression
 * prints its final value based on the assigment
 * prints a nandified, norified and simplified version for it.
 *
 */

public class ExpressionsTest {
    /**
     * Main method for the class.
     * activates all actions on the expression.
     * @param args - not used.
     * @throws Exception - if expression to be evaluated does not hold a defined value.
     */
    public static void main(String[] args) throws Exception {
        Map<String, Boolean> assignment = new TreeMap<>();
        Expression exp = new Or(new And(new Var("x"), new Xor(new Var("y"), new Var("y"))),
                new Var("z"));
        System.out.println(exp);
        assignment.put("x", true);
        assignment.put("y", true);
        assignment.put("z", false);

        System.out.println(exp.evaluate(assignment));
        System.out.println(exp.nandify());
        System.out.println(exp.norify());
        System.out.println(exp.simplify());
    }
}
