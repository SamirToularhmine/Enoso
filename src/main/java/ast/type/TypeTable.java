package ast.type;

import ast.Position;
import ast.Visitor;

public class TypeTable extends Type{

    public TypeTable(Position position){
        this.position = position;
    }

    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
