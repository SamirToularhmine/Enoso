package ast.opa;

import ast.Visitor;

public class OpaMultiplication extends Opa{
    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
