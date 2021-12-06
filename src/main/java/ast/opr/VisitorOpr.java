package ast.opr;


public interface VisitorOpr<T> {
    T visit(OprValue oprValue);

}
