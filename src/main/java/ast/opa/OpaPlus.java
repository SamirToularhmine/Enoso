package ast.opa;

import ast.Visitor;

public class OpaPlus extends Opa{
    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
