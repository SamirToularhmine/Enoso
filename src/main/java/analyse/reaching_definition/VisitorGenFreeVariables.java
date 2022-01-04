package analyse.reaching_definition;

import ast.DecVariable;
import ast.FunctionDeclaration.Declaration;
import ast.Program;
import ast.Visitor;
import ast.aexpression.*;
import ast.bexpression.BexpressionAexpressionOprAexpression;
import ast.bexpression.BexpressionConst;
import ast.bexpression.BexpressionNot;
import ast.bexpression.BexpressionParenthesis;
import ast.block.BlockStatement;
import ast.block.BlockWithinParenthesis;
import ast.opa.OpaValue;
import ast.opr.OprValue;
import ast.statement.*;
import ast.type.TypeTable;
import ast.type.TypeType;
import exceptions.InappropriateVisitException;
import org.antlr.v4.runtime.misc.Pair;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class VisitorGenFreeVariables implements Visitor<Set<Pair<String, Integer>>> {
    @Override
    public Set<Pair<String, Integer>> visit(Program program) {
        Set<Pair<String, Integer>> iota = new HashSet<>();

        program.getDeclarationList().forEach(declaration -> iota.addAll((Set<Pair<String, Integer>>) declaration.accept(this)));
        program.getStatements().forEach(statement -> iota.addAll((Set<Pair<String, Integer>>) statement.accept(this)));
        program.getlDeclVariables().forEach(decVariable -> iota.addAll((Set<Pair<String, Integer>>) decVariable.accept(this)));

        return iota;
    }

    @Override
    public Set<Pair<String, Integer>> visit(DecVariable decVariable) {
        Set<Pair<String, Integer>> iota = new HashSet<>();
        decVariable.getIdentifiers().forEach(identifer ->  iota.add(new Pair<>(identifer, -1)));
        return iota;
    }

    @Override
    public Set<Pair<String, Integer>> visit(Declaration declaration) {
        Set<Pair<String, Integer>> iota = new HashSet<>();

        declaration.getArguments().forEach(argument -> iota.add(new Pair<>(argument.getIdentifier(), -1)));
        if (declaration.getReturnType() != null)
            iota.add(new Pair<>(declaration.getReturnType().a, -1));

        declaration.getBody().forEach(statement -> iota.addAll((Set<Pair<String, Integer>>) statement.accept(this)));
        return iota;
    }

    @Override
    public Set<Pair<String, Integer>> visit(AexpressionArray aexpressionArray) {
        Set<Pair<String, Integer>> iota = new HashSet<>();

        iota.add(new Pair<>(aexpressionArray.getIdentifier(), -1));
        iota.addAll((Set<Pair<String, Integer>>) aexpressionArray.getIndex().accept(this));

        return iota;
    }

    @Override
    public Set<Pair<String, Integer>> visit(AexpressionBinary aexpressionBinary) {
        Set<Pair<String, Integer>> iota = new HashSet<>();
        iota.addAll((Set<Pair<String, Integer>>) aexpressionBinary.getLeft().accept(this));
        iota.addAll((Set<Pair<String, Integer>>) aexpressionBinary.getRight().accept(this));
        return iota;
    }

    @Override
    public Set<Pair<String, Integer>> visit(AexpressionConstant aexpressionConstant) {
        return new HashSet<>();
    }

    @Override
    public Set<Pair<String, Integer>> visit(AexpressionIdentifier aexpressionIdentifier) {
        Set<Pair<String, Integer>> iota = new HashSet<>();
        iota.add(new Pair<>(aexpressionIdentifier.getIdentifier(), -1));
        return iota;
    }

    @Override
    public Set<Pair<String, Integer>> visit(AexpressionNewArray aexpressionNewArray) {
        Set<Pair<String, Integer>> iota = new HashSet<>();
        iota.addAll((Set<Pair<String, Integer>>)aexpressionNewArray.getValue().accept(this));
        return iota;
    }

    @Override
    public Set<Pair<String, Integer>> visit(AexpressionParenthesis aexpressionParenthesis) {
        Set<Pair<String, Integer>> iota = new HashSet<>();
        iota.addAll((Set<Pair<String, Integer>>)aexpressionParenthesis.getAexpression().accept(this));
        return iota;
    }

    @Override
    public Set<Pair<String, Integer>> visit(AexpressionNeg aexpressionUnary) {
        Set<Pair<String, Integer>> iota = new HashSet<>();
        iota.addAll((Set<Pair<String, Integer>>)aexpressionUnary.getValue().accept(this));
        return iota;
    }

    @Override
    public Set<Pair<String, Integer>> visit(BexpressionAexpressionOprAexpression bexpressionAexpressionOprAexpression) {
        Set<Pair<String, Integer>> iota = new HashSet<>();
        iota.addAll((Set<Pair<String, Integer>>) bexpressionAexpressionOprAexpression.getLeft().accept(this));
        iota.addAll((Set<Pair<String, Integer>>) bexpressionAexpressionOprAexpression.getRight().accept(this));
        return iota;
    }

    @Override
    public Set<Pair<String, Integer>> visit(BexpressionConst bexpressionConst) {
        return new HashSet<>();
    }

    @Override
    public Set<Pair<String, Integer>> visit(BexpressionNot bexpressionNot) {
        Set<Pair<String, Integer>> iota = new HashSet<>();
        iota.addAll((Set<Pair<String, Integer>>) bexpressionNot.getValue().accept(this));
        return iota;
    }

    @Override
    public Set<Pair<String, Integer>> visit(BexpressionParenthesis bexpressionParenthesis) {
        Set<Pair<String, Integer>> iota = new HashSet<>();
        iota.addAll((Set<Pair<String, Integer>>) bexpressionParenthesis.getValue().accept(this));
        return iota;
    }

    @Override
    public Set<Pair<String, Integer>> visit(BlockStatement blockStatement) {
        Set<Pair<String, Integer>> iota = new HashSet<>();
        iota.addAll((Set<Pair<String, Integer>>) blockStatement.getStatement().accept(this));
        return iota;
    }

    @Override
    public Set<Pair<String, Integer>> visit(BlockWithinParenthesis blockWithinParenthesis) {
        Set<Pair<String, Integer>> iota = new HashSet<>();
        blockWithinParenthesis.getStatements().forEach(statement -> iota.addAll((Set<Pair<String, Integer>>) statement.accept(this)));
        return iota;
    }

    @Override
    public Set<Pair<String, Integer>> visit(OpaValue opaDivision) {
        throw new InappropriateVisitException(opaDivision);
    }

    @Override
    public Set<Pair<String, Integer>> visit(OprValue oprValue) {
        throw new InappropriateVisitException(oprValue);
    }

    @Override
    public Set<Pair<String, Integer>> visit(StatementAffectation statementAffectation) {
        Set<Pair<String, Integer>> iota = new HashSet<>();
        iota.add(new Pair<>(statementAffectation.getIdentifier(), -1));
        iota.addAll((Set<Pair<String, Integer>>) statementAffectation.getAexpression().accept(this));
        return iota;
    }

    @Override
    public Set<Pair<String, Integer>> visit(StatementCall statementCall) {
        Set<Pair<String, Integer>> iota = new HashSet<>();
        statementCall.getParameters().forEach(aexpression -> iota.addAll((Set<Pair<String, Integer>>) aexpression.accept(this)));
        return iota;
    }

    @Override
    public Set<Pair<String, Integer>> visit(StatementIf statementIf) {
        Set<Pair<String, Integer>> iota = new HashSet<>();
        iota.addAll((Set<Pair<String, Integer>>) statementIf.getCondition().accept(this));
        iota.addAll((Set<Pair<String, Integer>>) statementIf.getIfBlock().accept(this));
        if (statementIf.getElseBlock() != null)
            iota.addAll((Set<Pair<String, Integer>>) statementIf.getElseBlock().accept(this));
        return iota;
    }

    @Override
    public Set<Pair<String, Integer>> visit(StatementSkip statementSkip) {
        return new HashSet<>();
    }

    @Override
    public Set<Pair<String, Integer>> visit(StatementWhile statementWhile) {
        Set<Pair<String, Integer>> iota = new HashSet<>();
        iota.addAll((Set<Pair<String, Integer>>) statementWhile.getCondition().accept(this));
        iota.addAll((Set<Pair<String, Integer>>) statementWhile.getBlock().accept(this));
        return iota;
    }

    @Override
    public Set<Pair<String, Integer>> visit(TypeTable typeTable) {
        throw new InappropriateVisitException(typeTable);
    }

    @Override
    public Set<Pair<String, Integer>> visit(TypeType typeType) {
        throw new InappropriateVisitException(typeType);
    }
}
