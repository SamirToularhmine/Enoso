package ast.type;

import ast.Position;
import ast.Visitor;

public class TypeType extends Type{

    public TypeType(Position position) {
        this.position = position;
    }
    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);    }
}
