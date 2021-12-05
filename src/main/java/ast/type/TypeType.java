package ast.type;

import ast.Position;
import ast.Visitor;

public class TypeType extends Type{

    private String type;

    public TypeType(Position position, String type) {
        this.type = type;
        this.position = position;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);    }
}
