package ast.bexpression;

import ast.Visitor;

public class BexpressionParenthesis extends Bexpression{
    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
