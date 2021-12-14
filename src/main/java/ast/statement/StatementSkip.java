package ast.statement;

import ast.Position;
import ast.Visitor;

import java.util.Set;

public class StatementSkip extends Statement{

    public StatementSkip(Position pos) {
        this.position = pos;
    }

    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
