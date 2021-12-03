package ast.statement;

import ast.Visitor;

public class StatementSkip extends Statement{
    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
