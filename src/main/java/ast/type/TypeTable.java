package ast.type;

import ast.Visitor;

public class TypeTable extends Type{
    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
