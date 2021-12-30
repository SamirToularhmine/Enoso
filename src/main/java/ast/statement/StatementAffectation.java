package ast.statement;

import ast.Position;
import ast.Visitor;
import ast.aexpression.Aexpression;
import analyse.ITransferVisitor;

public class StatementAffectation extends Statement{
    private String identifier;
    private Aexpression aexpression;

    public StatementAffectation(Position position, String identifier, Aexpression aexpression) {
        this.position = position;
        this.identifier = identifier;
        this.aexpression = aexpression;
    }

    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public Object accept(ITransferVisitor visitor) {
        return visitor.visit(this);
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Aexpression getAexpression() {
        return aexpression;
    }

    public void setAexpression(Aexpression aexpression) {
        this.aexpression = aexpression;
    }
}
