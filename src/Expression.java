// Yair Cohen 313355786
import java.util.List;
import java.util.Map;
/**
 * Intreface for representation of any new logical expression - such as "and", "or", "nand", "not" etc.
 * author: Yair Cohen
 * version date: 06/05/22
 */
public interface Expression {
    /**
     * Evaluate the expression using the variable values provided
     * in the assignment, and return the result. If the expression
     * contains a variable which is not in the assignment, an exception
     * is thrown.
     * @param assignment table of values to be assigned to each variable in the expression.
     * @return the result of logical computing based on the assigned values in the map "assigment".
     */
    Boolean evaluate(Map<String, Boolean> assignment) throws Exception;

    /** A convenience method. Like the `evaluate(assignment)` method above,
     * but uses an empty assignment.
     * @return the result of logical computing - if has default values such as true or false.
     */
    Boolean evaluate() throws Exception;

    /**
     * @return a list of the variables in the expression.
     */
    List<String> getVariables();

    /**
     * @return a nice string representation of the expression.
     */
    String toString();

    /**
     * @param expression the new expression to replace the variable.
     * @param var the variable to be check if found in expression.
     * @return a new expression in which all occurrences of the variable
     * var are replaced with the provided expression (Does not modify the
     * current expression).
     */

    Expression assign(String var, Expression expression);

    /**
     * @return the expression tree resulting from converting all the operations to the logical Nand operation.
     */

    Expression nandify();

    /**
     * @return the expression tree resulting from converting all the operations to the logical Nor operation.
     */

    Expression norify();

    /**
     * @return a simplified version of the current expression.
     */

    Expression simplify();
}