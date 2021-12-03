package ast.opr;

import ast.Visitor;

public class OprGreater extends Opr{
    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
