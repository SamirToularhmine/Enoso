package ast.statement;

import ast.Visitor;

public class StatementIf extends Statement{
    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
