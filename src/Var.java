// Yair Cohen 313355786
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * Var class creates a new  single variable such as "x", "y".
 * variable itself is an expression
 * author: Yair Cohen
 * version date: 06/05/22
 */
public class Var implements Expression {
    // instance variables decleration
    private String variable;
    /**
     * Consturctor for Var class.
     * @param variable the name of the variable - a string
     */

    public Var(String variable) {
        this.variable = variable;
    }

    /**
     * Evaluate the expression using the variable values provided
     * in the assignment, and return the result. If the expression
     * contains a variable which is not in the assignment, an exception
     * is thrown.
     * @param assignment contains the data to be checked
     * @return the value of the variable according to the map
     */
    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        if (assignment.containsKey(variable)) {
            return assignment.get(variable);
        } else {
          throw new Exception("The variable is not assigned in the given assigment!");
        }
        /*try {
            return assignment.get(variable);
        }
        catch (Exception e) {
            throw new Exception("The variable is not assigned in the given assigment!");
        }*/
    }

    /**
     * A convenience method. Like the `evaluate(assignment)` method above,
     * but uses an empty assignment.
     */
    @Override
    public Boolean evaluate() throws Exception {
        throw new Exception("The given expression has not been assigned!");    }

    /**
     * Returns the variable.
     * @return a list of one item - the variable
     */
    @Override
    public List<String> getVariables() {
        List varList = new ArrayList<String>();
        varList.add(this.variable);
        return varList;
    }

    /**
     * Returns a new expression in which all occurrences of the variable
     * var are replaced with the provided expression (Does not modify the
     * current expression).
     *
     * @param var the variable to be replaced
     * @param expression the expression to replace the variable
     *                   in the returned new expression
     * @return a new expression as explained.
     */
    @Override
    public Expression assign(String var, Expression expression) {
        if (this.variable.equals(var)) {
            return expression;
        } else {
            return new Var(variable);
        }
    }

    /**
     * Returns the expression tree resulting from converting all the operations to the logical Nand operation.
     */
    @Override
    public Expression nandify() {
        return this;
    }

    /**
     * Returns the expression tree resulting from converting all the operations to the logical Nor operation.
     */
    @Override
    public Expression norify() {
        return this;
    }

    /**
     * Returned a simplified version of the current expression.
     */
    @Override
    public Expression simplify() {
        return this;
    }

    @Override
    public String toString() {
        return this.variable;
    }
}
