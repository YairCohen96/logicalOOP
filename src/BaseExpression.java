// Yair Cohen 313355786
import java.util.List;
import java.util.Map;
/**
 * Represents  a new generic logical expression.
 * author: Yair Cohen
 * version date: 06/05/22
 */

public class BaseExpression implements Expression {
    private Expression baseExp;

    /**
     * Constructor for class BaseExpression.
     * @param exp - the new expression to be built
     */
    public BaseExpression(Expression exp) {
        baseExp = exp;
    }

    protected Expression getExp() {
        return baseExp;
    }

    /**
     * Evaluate the expression using the variable values provided
     * in the assignment, and return the result. If the expression
     * contains a variable which is not in the assignment, an exception
     * is thrown.
     *
     * @param assignment
     */
    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return baseExp.evaluate(assignment);
    }


    /**
     * A convenience method. Like the `evaluate(assignment)` method above,
     * but uses an empty assignment.
     */
    @Override
    public Boolean evaluate() throws Exception {
        return baseExp.evaluate();
    }


    /**
     * Returns a list of the variables in the expression.
     *
     * @return a list of the variables in the expression.
     */
    @Override
    public List<String> getVariables() {
        return baseExp.getVariables();
    }

    /**
     * Returns a new expression in which all occurrences of the variable
     * var are replaced with the provided expression (Does not modify the
     * current expression).
     *
     * @param var
     * @param expression
     */
    @Override
    public Expression assign(String var, Expression expression) {
       Expression temp = new BaseExpression(getExp().assign(var, expression));
        /*for (int i = 0; i < temp.getVariables().size(); i++) {
            if (var.equals(temp.getVariables().get(i))) {
                temp.getVariables().set(i, expression.toString());
            }
        }*/
        return temp;
    }

    /**
     * Returns the expression tree resulting from converting all the operations to the logical Nand operation.
     */
    @Override
    public Expression nandify() {
        return null;
    }

    /**
     * Returns the expression tree resulting from converting all the operations to the logical Nor operation.
     */
    @Override
    public Expression norify() {
        return null;
    }

    /**
     * Returned a simplified version of the current expression.
     */
    @Override
    public Expression simplify() {
        return null;
    }

    @Override
    public String toString() {
        return baseExp.toString();
    }
}