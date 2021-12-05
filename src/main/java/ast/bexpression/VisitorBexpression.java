package ast.bexpression;


public interface VisitorBexpression<T> {
    T visit(BexpressionAexpressionOprAexpression bexpressionAexpressionOprAexpression);
    T visit(BexpressionConst bexpressionConst);
    T visit(BexpressionNot bexpressionNot);
    T visit(BexpressionParenthesis bexpressionParenthesis);

}
