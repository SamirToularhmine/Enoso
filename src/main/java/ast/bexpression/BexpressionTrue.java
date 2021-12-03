package ast.bexpression;

import ast.Visitor;

public class BexpressionTrue extends Bexpression{
    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
