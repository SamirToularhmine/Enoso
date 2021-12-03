package ast.statement;

import ast.Position;
import ast.Visitor;
import ast.aexpression.Aexpression;

import java.util.List;

public class StatementCall extends Statement{
    private String identifier;
    private List<Aexpression> parameters;

    public StatementCall(Position position, String identifier, List<Aexpression> parameters) {
        this.position = position;
        this.identifier = identifier;
        this.parameters = parameters;
    }

    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public List<Aexpression> getParameters() {
        return parameters;
    }

    public void setParameters(List<Aexpression> parameters) {
        this.parameters = parameters;
    }
}
