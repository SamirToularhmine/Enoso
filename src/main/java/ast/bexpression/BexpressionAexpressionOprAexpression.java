package ast.bexpression;

import ast.Position;
import ast.Visitor;
import ast.aexpression.Aexpression;
import ast.opr.Opr;
import analyse.ITransferVisitor;

import java.util.Objects;

public class BexpressionAexpressionOprAexpression extends Bexpression{

    private Aexpression left, right;
    private Opr opr;

    public BexpressionAexpressionOprAexpression(Position position, Aexpression left, Aexpression right, Opr opr) {
        this.left = left;
        this.right = right;
        this.opr = opr;
        this.position = position;
    }

    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public Object accept(ITransferVisitor visitor) {
        return visitor.visit(this);
    }

    public Aexpression getLeft() {
        return left;
    }

    public void setLeft(Aexpression left) {
        this.left = left;
    }

    public Aexpression getRight() {
        return right;
    }

    public void setRight(Aexpression right) {
        this.right = right;
    }

    public Opr getOpr() {
        return opr;
    }

    public void setOpr(Opr opr) {
        this.opr = opr;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left.hashCode(), right.hashCode(), opr.hashCode());
    }
}
