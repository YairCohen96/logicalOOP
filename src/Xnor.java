// Yair Cohen 313355786
import java.util.Map;
/**
 * Xnor class creates a new "xnor" logical expression.
 * author: Yair Cohen
 * version date: 06/05/22
 */

public class Xnor extends BinaryExpression implements Expression {
    /**
     * Consturctor for Xnor class.
     * @param exp1 - first sub-expression of logical xnor
     * @param exp2 - second sub-expression of logical xnor
     */
    public Xnor(Expression exp1, Expression exp2) {
        super(exp1, exp2);
    }
    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return getExp1().evaluate(assignment) == getExp2().evaluate(assignment);
    }
    @Override
    public Boolean evaluate() throws Exception {
        return getExp1().evaluate() == getExp2().evaluate();
    }

    @Override
    public Expression nandify() {
        // A XNOR B = [ ( A NAND A ) NAND ( B NAND B ) ] NAND ( A NAND B )
        return new Nand(new Nand(new Nand(getExp1().nandify(), getExp1().nandify()),
                            new Nand(getExp2().nandify(), getExp2().nandify())),
                        new Nand(getExp1().nandify(), getExp2().nandify()));
    }

    @Override
    public Expression norify() {
        // A XNOR B = [ A NOR ( A NOR B ) ] NOR [ B NOR ( A NOR B )
        return new Nor(new Nor(getExp1().norify(), new Nor(getExp1().norify(), getExp2().norify())),
                new Nor(getExp2().norify(), new Nor(getExp1().norify(), getExp2().norify())));
    }
    @Override
    public Expression simplify() {
        /*if (getExp1().simplify().toString().equals(new Val(true).toString())) {
            return getExp2().simplify(); // T # x = x
        } else if (getExp1().simplify().toString().equals(new Val(false).toString())) {
            return new Not(getExp2()).simplify(); // F # x = ~x
        } else if (getExp2().simplify().toString().equals(new Val(true).toString())) {
            return getExp1().simplify();
        } else if (getExp2().simplify().toString().equals(new Val(false).toString())) {
            return new Not(getExp1()).simplify();
        }  else*/
        if (getExp1().simplify().toString().equals(getExp2().simplify().toString())) {
            return new Val(true); // x # x = T
        } else if (getExp1().simplify().toString().equals(new Val(true).toString())
                    && getExp2().simplify().toString().equals(new Val(false).toString())
                || getExp1().simplify().toString().equals(new Val(false).toString())
                    && getExp2().simplify().toString().equals(new Val(true).toString())) {
            return new Val(false); // T # F = F
        } else {
            return new Xnor(getExp1().simplify(), getExp2().simplify());
        }
    }
    @Override
    public Expression assign(String var, Expression expression) {
        Expression temp = new Xnor(getExp1().assign(var, expression), getExp2().assign(var, expression));
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
        return "(" + getExp1().toString() + " # " + getExp2().toString() + ")";
    }
}
