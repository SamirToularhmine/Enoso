package ast.aexpression;

import ast.Position;
import ast.Visitor;
import ast.type.Type;

public class AexpressionNewArray extends Aexpression {
    private Type type;
    private Aexpression value;

    public AexpressionNewArray(Position position, Type type, Aexpression value) {
        this.position = position;
        this.type = type;
        this.value = value;
    }

    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Aexpression getValue() {
        return value;
    }

    public void setValue(Aexpression value) {
        this.value = value;
    }
}
