package ast.type;

import ast.Visitor;

public class TypeType extends Type{
    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);    }
}
