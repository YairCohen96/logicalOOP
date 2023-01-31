// Yair Cohen 313355786
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * Var class creates a new  single value - true or false.
 * variable itself is an expression
 * author: Yair Cohen
 * version date: 06/05/22
 */
public class Val implements Expression {
    private boolean value;
    /**
     * Consturctor for Val class.
     * @param val the value to be assigned.
     */

    public Val(boolean val) {
        value = val;
    }
    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return value;
    }
    @Override
    public Boolean evaluate() throws Exception {
        return value;
    }

    /**
     * Returns a list of the variables in the expression.
     *
     * @return an empty list.
     */
    @Override
    public List<String> getVariables() {
        return new ArrayList<>(); //empty list
    }

    /**
     * Simply returns the value, there are no variables
     * involoved.
     *
     * @param var variable to be checked
     * @param expression to replace variable if found
     * @return the value;
     */
    @Override
    public Expression assign(String var, Expression expression) {
        return this;
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
        if (value) {
            return "T";
        } else  {
            return "F";
        }
    }
}
