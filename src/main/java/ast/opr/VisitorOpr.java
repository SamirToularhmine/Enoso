package ast.opr;


public interface VisitorOpr<T> {
    T visit(OprDifferent oprDifferent);
    T visit(OprEqual oprEqual);
    T visit(OprGreater oprGreater);
    T visit(OprGreaterOrEqual oprGreaterOrEqual);
    T visit(OprLower oprLower);
    T visit(OprLowerOrEqual orEqual);


    T visit(OprValue oprValue);

}
