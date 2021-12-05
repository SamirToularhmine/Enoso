package ast.opa;

import ast.Visitor;

public class OpaDivision extends Opa{
    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
