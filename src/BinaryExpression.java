// Yair Cohen 313355786
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * Represents  a new binary logical expression - such as "and", "or", "nand" etc.
 * author: Yair Cohen
 * version date: 06/05/22
 */
public class BinaryExpression extends BaseExpression implements Expression {
    private Expression exp2;

    /**
     * Constructor for BinaryExpression class.
     * @param exp1 first sub-expression of logical expression
     * @param exp2 second sub-expression of logical expression
     */
    public BinaryExpression(Expression exp1, Expression exp2) {
        super(exp1);
        /*// put in advance to lexicographic order - for commutative simplification
        if(exp1.toString().compareTo(exp2.toString()) > 0 ) {
            this.exp1 = exp2;
            this.exp2 = exp1;
        } else {
            this.exp1 = exp1;
            this.exp2 = exp2;
        }*/
        //this.exp1 = super.getExp();
        this.exp2 = exp2;
    }
    protected Expression getExp1() {
        return super.getExp();
    }
    protected Expression getExp2() {
        return exp2;
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
        return null;
    }

    /**
     * A convenience method. Like the `evaluate(assignment)` method above,
     * but uses an empty assignment.
     */
    @Override
    public Boolean evaluate() throws Exception {
        return null;
    }

    /**
     * Returns a list of the variables in the expression.
     *
     * @return a list of the variables in the expression.
     */
    @Override
    public List<String> getVariables() {
        List<String> combined = new ArrayList<>(getExp1().getVariables());
        for (int i = 0; i < getExp2().getVariables().size(); i++) {
            if (!combined.contains(getExp2().getVariables().get(i))) {
                combined.add(getExp2().getVariables().get(i));
            }
        }
        //combined.(exp2.getVariables());
        return combined;
    }
    @Override
    public Expression assign(String var, Expression expression) {
        Expression temp = new BinaryExpression(getExp1(), getExp2());
        // referring to the combined list of variables
        for (int i = 0; i < temp.getVariables().size(); i++) {
            if (var.equals(temp.getVariables().get(i))) {
                temp.getVariables().set(i, expression.toString());
            }
        }
        return temp;
    }
   /*@Override
    public Expression nandify() {
        return new Nand(getExp1().nandify(), getExp2().nandify());
    }
    @Override
    public Expression norify() {
        return new Nor(getExp1().norify(), getExp2().norify());
    }
    @Override
    public  Expression simplify() {
        return new BinaryExpression(getExp1().simplify(), getExp2().simplify());
    }*/
    @Override
    public String toString() {
        return "(" + getExp1().toString() + " " + exp2.toString() + ")";
    }
}
