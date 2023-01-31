// Yair Cohen
import java.util.Map;
/**
 * Nand class creates a new "nand" logical expression.
 * author: Yair Cohen
 * version date: 06/05/22
 */
public class Nand extends  BinaryExpression implements Expression {
    /**
     * Constructor for Nand class.
     * @param exp1 - first sub-expression of logical nand
     * @param exp2 - second sub-expression of logical nand
     */
    public Nand(Expression exp1, Expression exp2) {
        super(exp1, exp2);
    }
    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return !(getExp1().evaluate(assignment) && getExp2().evaluate(assignment));
    }
    @Override
    public Boolean evaluate() throws Exception {
        return !(getExp1().evaluate() && getExp2().evaluate());
    }
    @Override
    public Expression assign(String var, Expression expression) {
        Expression temp = new Nand(getExp1().assign(var, expression), getExp2().assign(var, expression));
        // referring to the combined list of variables
        /*for (int i = 0; i < temp.getVariables().size(); i++) {
            if (temp.getVariables().get(i).contains(var)) {
                temp.getVariables().set(i, expression.toString());
            }
        }*/
        return temp;
    }
    @Override
    public Expression nandify() {
        // No change
        return new Nand(getExp1().nandify(), getExp2().nandify());
    }

    @Override
    public Expression norify() {
        // A NAND B = [ ( A NOR A ) NOR ( B NOR B ) ] NOR [ ( A NOR A ) NOR ( B NOR B ) ]
        return new Nor(new Nor(new Nor(getExp1().norify(), getExp1().norify()),
                                new Nor(getExp2().norify(), getExp2().norify())),
                        new Nor(new Nor(getExp1().norify(), getExp1().norify()),
                                new Nor(getExp2().norify(), getExp2().norify())));
    }

    @Override
    public Expression simplify() {
        if (getExp1().simplify().toString().equals(new Val(true).toString())) {
            return new Not(getExp2()).simplify(); // T A x = ~x
        } else if (getExp1().simplify().toString().equals(new Val(false).toString())) {
            return new Val(true); // F A x = T
        } else if (getExp2().simplify().toString().equals(new Val(true).toString())) {
            return new Not(getExp1()).simplify();
        } else if (getExp2().simplify().toString().equals(new Val(false).toString())) {
            return new Val(true);
        } else if (getExp1().simplify().toString().equals(getExp2().simplify().toString())) {
            return new Not(getExp1()).simplify(); // x A x = ~x
        } else {
            return new Nand(getExp1().simplify(), getExp2().simplify());
        }
    }
    @Override
    public String toString() {
        return "(" + getExp1().toString() + " A " + getExp2().toString() + ")";
    }
}