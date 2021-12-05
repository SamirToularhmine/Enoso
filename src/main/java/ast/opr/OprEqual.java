package ast.opr;

import ast.Visitor;

public class OprEqual extends Opr{
    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
