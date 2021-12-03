package ast.opr;

import ast.Visitor;

public class OprLower extends Opr{
    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
