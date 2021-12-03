package ast.statement;

import ast.block.BlockStatement;

public interface VisitorStatement<T>{
    T visit(StatementAffectation statementAffectation);
    T visit(StatementCall statementCall);
    T visit(StatementIf statementIf);
    T visit(StatementSkip statementSkip);
    T visit(StatementWhile statementWhile);

}
