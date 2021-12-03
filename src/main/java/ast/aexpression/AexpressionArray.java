package ast.aexpression;

import ast.Visitor;

public class AexpressionArray extends Aexpression {
    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
