package ast.opr;

import ast.Visitor;

public class OprDifferent extends Opr{
    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
