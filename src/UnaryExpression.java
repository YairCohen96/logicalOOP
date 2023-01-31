// Yair Cohen 313355786
/**
 * Represents  a new unary logical expression - such as "not".
 * author: Yair Cohen
 * version date: 06/05/22
 */

public class UnaryExpression extends BaseExpression implements Expression {
    /**
     * Constructor for class UnaryExpression.
     * @param exp - the new expression to be built
     */
    public UnaryExpression(Expression exp) {
        super(exp);
    }
    @Override
    public Expression simplify() {
        return null;
    }

}