package ast.statement;

import analyse.State;

import java.util.Set;

public interface TransferVisitorStatement<T> {
    T visit(StatementAffectation statementAffectation, Set<State> nodes);
    T visit(StatementCall statementCall, Set<State> nodes);
    T visit(StatementIf statementIf, Set<State> nodes);
    T visit(StatementSkip statementSkip, Set<State> nodes);
    T visit(StatementWhile statementWhile, Set<State> nodes);
}
