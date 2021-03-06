package ast.statement;

import ast.Position;
import ast.Visitor;
import analyse.ITransferVisitor;

public class StatementSkip extends Statement{

    public StatementSkip(Position pos) {
        this.position = pos;
    }

    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public Object accept(ITransferVisitor visitor) {
        return visitor.visit(this);
    }
}
