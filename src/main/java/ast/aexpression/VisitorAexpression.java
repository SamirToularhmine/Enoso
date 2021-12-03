package ast.aexpression;

public interface VisitorAexpression<T> {
    T visit(AexpressionArray aexpressionArray);
    T visit(AexpressionBinary aexpressionBinary);
    T visit(AexpressionConstant aexpressionConstant);
    T visit(AexpressionIdentifier aexpressionIdentifier);
    T visit(AexpressionNew aexpressionNew);
    T visit(AexpressionParenthesis aexpressionParenthesis);
    T visit(AexpressionUnary aexpressionUnary);


}
