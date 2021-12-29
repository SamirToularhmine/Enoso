package analyse.available_expressions;

import analyse.State;
import ast.*;
import ast.FunctionDeclaration.Declaration;
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
import analyse.ITransferVisitor;
import ast.type.TypeTable;
import ast.type.TypeType;
import exceptions.InappropriateVisitException;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TransferVisitorAvailableExpression implements ITransferVisitor<Set<Aexpression>> {

    private Set<State> allNodes;
    private Set<Aexpression> currentValue;
    private Set<Aexpression> aeStar;

    public TransferVisitorAvailableExpression(Set<State> allNodes) {
        this.allNodes = new HashSet<>(allNodes);
        this.currentValue = new HashSet<>();
        this.aeStar = new HashSet<>();

        // On crée toutes les expressions et sous expressions du programme
        VisitorGenAeStar visitorGenAeStar = new VisitorGenAeStar();
        VisitorPrint visitorPrint = new VisitorPrint();
        this.allNodes.forEach(n -> aeStar.addAll((Set<Aexpression>) n.getInstruction().accept(visitorGenAeStar)));
        aeStar.forEach(a -> System.out.println(a.accept(visitorPrint)));
    }

    public void reset(Set<Aexpression> currentValue){
        this.currentValue = currentValue;
    }

    @Override
    public Set<Aexpression> visit(StatementAffectation statementAffectation) {
        // - Kill + Gen
        Set<Aexpression> result = new HashSet<>(this.currentValue != null ? this.currentValue : new HashSet<>());
        String identifier = statementAffectation.getIdentifier();
        Set<Aexpression> kill = this.aeStar.stream().filter(a -> a.contains(identifier)).collect(Collectors.toSet());

        Set<Aexpression> gen = new HashSet<>();
        Set<Aexpression> genExp = (Set<Aexpression>) statementAffectation.getAexpression().accept(this);
        if(genExp != null){
            gen.addAll(genExp.stream().filter(a -> !a.contains(identifier)).collect(Collectors.toSet()));
        }

        // result - kill
        result.removeAll(kill);

        // + gen
        result.addAll(gen);

        return result;
    }

    @Override
    public Set<Aexpression> visit(StatementCall statementCall) {
        throw new InappropriateVisitException(statementCall);
    }

    @Override
    public Set<Aexpression> visit(StatementIf statementIf) {
        throw new InappropriateVisitException(statementIf);
    }

    @Override
    public Set<Aexpression> visit(StatementSkip statementSkip) {
        throw new InappropriateVisitException(statementSkip);
    }

    @Override
    public Set<Aexpression> visit(StatementWhile statementWhile) {
        throw new InappropriateVisitException(statementWhile);
    }

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
        throw new InappropriateVisitException(aexpressionArray);
    }

    @Override
    public Set<Aexpression> visit(AexpressionBinary aexpressionBinary) {
        return this.aeStar.stream().filter(a -> a.equals(aexpressionBinary.getLeft()) || a.equals(aexpressionBinary.getRight()) || a.equals(aexpressionBinary)).collect(Collectors.toSet());
    }

    @Override
    public Set<Aexpression> visit(AexpressionConstant aexpressionConstant) {
        return null;
    }

    @Override
    public Set<Aexpression> visit(AexpressionIdentifier aexpressionIdentifier) {
        return null;
    }

    @Override
    public Set<Aexpression> visit(AexpressionNewArray aexpressionNewArray) {
        throw new InappropriateVisitException(aexpressionNewArray);
    }

    @Override
    public Set<Aexpression> visit(AexpressionParenthesis aexpressionParenthesis) {
        throw new InappropriateVisitException(aexpressionParenthesis);
    }

    @Override
    public Set<Aexpression> visit(AexpressionNeg aexpressionUnary) {
        throw new InappropriateVisitException(aexpressionUnary);
    }

    @Override
    public Set<Aexpression> visit(BexpressionAexpressionOprAexpression bexpressionAexpressionOprAexpression) {
        Set<Aexpression> result = new HashSet<>(this.currentValue != null ? this.currentValue : new HashSet<>());

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
        throw new InappropriateVisitException(bexpressionConst);
    }

    @Override
    public Set<Aexpression> visit(BexpressionNot bexpressionNot) {
        throw new InappropriateVisitException(bexpressionNot);
    }

    @Override
    public Set<Aexpression> visit(BexpressionParenthesis bexpressionParenthesis) {
        throw new InappropriateVisitException(bexpressionParenthesis);
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
    public Set<Aexpression> visit(TypeTable typeTable) {
        throw new InappropriateVisitException(typeTable);
    }

    @Override
    public Set<Aexpression> visit(TypeType typeType) {
        throw new InappropriateVisitException(typeType);
    }
}
