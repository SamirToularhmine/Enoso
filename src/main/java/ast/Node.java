package ast;

import ast.transfer.ITransferVisitor;
import exceptions.InappropriateVisitException;

public abstract class Node<T> {
    protected Position position;

    public Position getPosition() {
        return position;
    }

    public T accept(Visitor<T> visitor){
        throw new InappropriateVisitException(this);
    }

    public T accept(ITransferVisitor<T> visitor){
        throw new InappropriateVisitException(this);
    }

}
