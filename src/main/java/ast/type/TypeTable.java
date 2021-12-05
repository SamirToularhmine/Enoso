package ast.type;

import ast.Position;
import ast.Visitor;

public class TypeTable extends Type{

    private TypeType type;

    public TypeTable(Position position, TypeType type){
        this.type = type;
        this.position = position;
    }


    public TypeType getType() {
        return type;
    }

    public void setType(TypeType type) {
        this.type = type;
    }

    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
