package ast.block;

import ast.Position;
import ast.Visitor;
import ast.statement.Statement;

import java.util.List;

public class BlockWithinParenthesis extends Block{
    private List<Statement> statements;

    public BlockWithinParenthesis(Position position, List<Statement> statements) {
        this.position = position;
        this.statements = statements;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public void setStatements(List<Statement> statements) {
        this.statements = statements;
    }

    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
