package ast;

public abstract class Node<T> {
    protected Position position;

    public Position getPosition() {
        return position;
    }

    public abstract T accept(Visitor<T> visitor);
}
