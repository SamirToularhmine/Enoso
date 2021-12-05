package ast.type;

import ast.Position;
import ast.Visitor;

public class TypeTable extends Type{

    private Type type;

    public TypeTable(Position position, Type type){
        this.type = type;
        this.position = position;
    }


    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
