package ast.opr;

import ast.Visitor;

public class OprGreaterOrEqual extends Opr{
    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
