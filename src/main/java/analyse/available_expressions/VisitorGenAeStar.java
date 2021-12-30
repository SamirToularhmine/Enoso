package analyse.available_expressions;

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

import java.util.HashSet;
import java.util.Set;

public class VisitorGenAeStar implements Visitor<Set<Aexpression>> {
    @Override
    public Set<Aexpression> visit(Program program) {
        throw new InappropriateVisitException(program);
    }

    @Override
    public Set<Aexpression> visit(DecVariable decVariable) {
        throw new InappropriateVisitException(decVariable);
    }

    @Override
    public Set<Aexpression> visit(Declaration declaration) {
        throw new InappropriateVisitException(declaration);
    }

    @Override
    public Set<Aexpression> visit(AexpressionArray aexpressionArray) {
        Set<Aexpression> result = new HashSet<>();

        result.addAll((Set<Aexpression>)aexpressionArray.getIndex().accept(this));

        return result;
    }

    @Override
    public Set<Aexpression> visit(AexpressionBinary aexpressionBinary) {
        Set<Aexpression> result = new HashSet<>();

        result.add(aexpressionBinary);
        Set<Aexpression> left = (Set<Aexpression>)aexpressionBinary.getLeft().accept(this);
        if(left != null){
            result.addAll(left);

        }

        Set<Aexpression> right = (Set<Aexpression>)aexpressionBinary.getRight().accept(this);
        if(right != null){
            result.addAll(right);

        }

        return result;
    }

    @Override
    public Set<Aexpression> visit(AexpressionConstant aexpressionConstant) {
        return new HashSet<>();
    }

    @Override
    public Set<Aexpression> visit(AexpressionIdentifier aexpressionIdentifier) {
        return new HashSet<>();
    }

    @Override
    public Set<Aexpression> visit(AexpressionNewArray aexpressionNewArray) {
        Set<Aexpression> gen = (Set<Aexpression>) aexpressionNewArray.getValue().accept(this);

        if(gen != null){
            return new HashSet<>(gen);
        }

        return new HashSet<>();
    }

    @Override
    public Set<Aexpression> visit(AexpressionParenthesis aexpressionParenthesis) {
        Set<Aexpression> gen = (Set<Aexpression>) aexpressionParenthesis.getAexpression().accept(this);

        if(gen != null){
            return new HashSet<>(gen);
        }

        return new HashSet<>();
    }

    @Override
    public Set<Aexpression> visit(AexpressionNeg aexpressionUnary) {
        Set<Aexpression> result = new HashSet<>();

        result.add(aexpressionUnary);

        Set<Aexpression> gen = (Set<Aexpression>)aexpressionUnary.getValue().accept(this);
        if(gen != null){
            result.addAll(gen);
        }

        return result;
    }

    @Override
    public Set<Aexpression> visit(BexpressionAexpressionOprAexpression bexpressionAexpressionOprAexpression) {
        Set<Aexpression> result = new HashSet<>();

        Set<Aexpression> left = (Set<Aexpression>)bexpressionAexpressionOprAexpression.getLeft().accept(this);
        if(left != null){
            result.addAll(left);
        }

        Set<Aexpression> right = (Set<Aexpression>)bexpressionAexpressionOprAexpression.getRight().accept(this);
        if(right != null){
            result.addAll(right);
        }

        return result;
    }

    @Override
    public Set<Aexpression> visit(BexpressionConst bexpressionConst) {
        return new HashSet<>();
    }

    @Override
    public Set<Aexpression> visit(BexpressionNot bexpressionNot) {
        Set<Aexpression> gen = (Set<Aexpression>) bexpressionNot.getValue().accept(this);
        if(gen != null){
            return new HashSet<>(gen);
        }

        return new HashSet<>();
    }

    @Override
    public Set<Aexpression> visit(BexpressionParenthesis bexpressionParenthesis) {
        Set<Aexpression> gen = (Set<Aexpression>) bexpressionParenthesis.getValue().accept(this);
        if(gen != null){
            return new HashSet<>(gen);
        }

        return new HashSet<>();
    }

    @Override
    public Set<Aexpression> visit(BlockStatement blockStatement) {
        throw new InappropriateVisitException(blockStatement);
    }

    @Override
    public Set<Aexpression> visit(BlockWithinParenthesis blockWithinParenthesis) {
        throw new InappropriateVisitException(blockWithinParenthesis);
    }

    @Override
    public Set<Aexpression> visit(OpaValue opaDivision) {
        throw new InappropriateVisitException(opaDivision);
    }

    @Override
    public Set<Aexpression> visit(OprValue oprValue) {
        throw new InappropriateVisitException(oprValue);
    }

    @Override
    public Set<Aexpression> visit(StatementAffectation statementAffectation) {
        Set<Aexpression> expressions = (Set<Aexpression>) statementAffectation.getAexpression().accept(this);
        if(expressions != null){
            return new HashSet<>(expressions);
        }

        return new HashSet<>();
    }

    @Override
    public Set<Aexpression> visit(StatementCall statementCall) {
        if(statementCall.getParameters() != null){
            Set<Aexpression> result = new HashSet<>();

            for (Aexpression parameter : statementCall.getParameters()) {
                if(parameter != null){
                    Set<Aexpression> paramGen = (Set<Aexpression>) parameter.accept(this);

                    if(paramGen != null){
                        result.add(parameter);
                        result.addAll(paramGen);
                    }
                }
            }

            return result;
        }

        return new HashSet<>();
    }

    @Override
    public Set<Aexpression> visit(StatementIf statementIf) {
        throw new InappropriateVisitException(statementIf);
    }

    @Override
    public Set<Aexpression> visit(StatementSkip statementSkip) {
        return new HashSet<>();
    }

    @Override
    public Set<Aexpression> visit(StatementWhile statementWhile) {
        throw new InappropriateVisitException(statementWhile);
    }

    @Override
    public Set<Aexpression> visit(TypeTable typeTable) {
        throw new InappropriateVisitException(typeTable);
    }

    @Override
    public Set<Aexpression> visit(TypeType typeType) {
        throw new InappropriateVisitException(typeType);
    }
}
