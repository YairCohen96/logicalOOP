// Yair Cohen 313355786
import java.util.Map;
/**
 * Represents  a new "not" logical expression.
 * author: Yair Cohen
 * version date: 06/05/22
 */
public class Not extends UnaryExpression implements Expression {
    /**
     * Constructor for class UnaryExpression.
     * @param exp - the new expression to be negated
     */
    public Not(Expression exp) {
        super(exp);
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
        return !(getExp().evaluate(assignment));
    }

    /**
     * A convenience method. Like the `evaluate(assignment)` method above,
     * but uses an empty assignment.
     */
    @Override
    public Boolean evaluate() throws Exception {
        return !(getExp().evaluate());
    }
  @Override
    public Expression nandify() {
        // Not x = x Nand x
        return new Nand(getExp().nandify(), getExp().nandify());
  }

  @Override
    public Expression norify() {
        // Not x = x Nor x
        return new Nor(getExp().norify(), getExp().norify());
    }
  @Override
  public Expression simplify() {
        if (getExp().simplify().toString().equals(new Val(true).toString())) {
            return new Val(false);
        } else if (getExp().simplify().toString().equals(new Val(false).toString())) {
            return new Val(true);
        } else {
            return new Not(getExp().simplify());
        }
  }
    @Override
    public Expression assign(String var, Expression expression) {
        Expression temp = new Not(getExp().assign(var, expression));
        // referring to the combined list of variables
        /*for (int i = 0; i < temp.getVariables().size(); i++) {
            if (temp.getVariables().get(i).contains(var)) {
                temp.getVariables().set(i, expression.toString());
            }
        }*/
        return temp;
    }

  @Override
    public String toString() {
        return "~(" + getExp().toString() + ")";
    }
}
