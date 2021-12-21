package ast;

import analyse.State;
import ast.transfer.TransferVisitor;

import java.util.Set;

public abstract class Node<T> {
    protected Position position;

    public Position getPosition() {
        return position;
    }

    public abstract T accept(Visitor<T> visitor);

}
