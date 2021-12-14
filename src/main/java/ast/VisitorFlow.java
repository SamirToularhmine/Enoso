package ast;

import analyse.Flow;
import analyse.State;
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
import ast.type.TypeTable;
import ast.type.TypeType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VisitorFlow implements Visitor<Flow>{

    @Override
    public Flow visit(Program program) {
        Flow flow = new Flow();

        // Boucle sur les déclarations de procédures

        for(Statement s : program.getStatements()){

        }

        return flow;
    }

    @Override
    public Flow visit(DecVariable decVariable) {
        return null;
    }

    @Override
    public Flow visit(Declaration declaration) {
        return null;
    }

    @Override
    public Flow visit(AexpressionArray aexpressionArray) {
        return null;
    }

    @Override
    public Flow visit(AexpressionBinary aexpressionBinary) {
        return null;
    }

    @Override
    public Flow visit(AexpressionConstant aexpressionConstant) {
        return null;
    }

    @Override
    public Flow visit(AexpressionIdentifier aexpressionIdentifier) {
        return null;
    }

    @Override
    public Flow visit(AexpressionNewArray aexpressionNewArray) {
        return null;
    }

    @Override
    public Flow visit(AexpressionParenthesis aexpressionParenthesis) {
        return null;
    }

    @Override
    public Flow visit(AexpressionNeg aexpressionUnary) {
        return null;
    }

    @Override
    public Flow visit(BexpressionAexpressionOprAexpression bexpressionAexpressionOprAexpression) {
        return null;
    }

    @Override
    public Flow visit(BexpressionConst bexpressionConst) {
        return null;
    }

    @Override
    public Flow visit(BexpressionNot bexpressionNot) {
        return null;
    }

    @Override
    public Flow visit(BexpressionParenthesis bexpressionParenthesis) {
        return null;
    }

    @Override
    public Flow visit(BlockStatement blockStatement) {
        return null;
    }

    @Override
    public Flow visit(BlockWithinParenthesis blockWithinParenthesis) {
        return null;
    }

    @Override
    public Flow visit(OpaValue opaDivision) {
        return null;
    }

    @Override
    public Flow visit(OprValue oprValue) {
        return null;
    }

    @Override
    public Flow visit(StatementAffectation statementAffectation) {
        return null;
    }

    @Override
    public Flow visit(StatementCall statementCall) {
        return null;
    }

    @Override
    public Flow visit(StatementIf statementIf) {
        Flow flowFinal = new Flow();

        Flow flowCond = (Flow) statementIf.getCondition().accept(this);
        Flow flowIfBlock = (Flow) statementIf.getIfBlock().accept(this);
        Flow flowElseBlock;

        flowFinal.setHead(List.of(flowCond.getHead().get(0)));
        flowFinal.setFinals(new ArrayList<>(flowIfBlock.getFinals()));
        flowFinal.getHead().get(0).setChildren(flowIfBlock.getHead());

        // Il peut ne pas y avoir de else block
        if(statementIf.getElseBlock() != null){
            flowElseBlock = (Flow) statementIf.getElseBlock().accept(this);
            flowFinal.getFinals().addAll(flowElseBlock.getFinals());
            flowFinal.getHead().get(0).getChildren().addAll(flowElseBlock.getHead());
        }

        return flowFinal;
    }

    @Override
    public Flow visit(StatementSkip statementSkip) {
        return new Flow();
    }

    @Override
    public Flow visit(StatementWhile statementWhile) {
        Flow flowFinal = new Flow();

        Flow fbexp = (Flow) statementWhile.getCondition().accept(this);
        Flow fblock = (Flow) statementWhile.getBlock().accept(this);

        flowFinal.setHead(new ArrayList<>(fbexp.getHead()));
        flowFinal.getHead().get(0).setChildren(List.of(fblock.getHead().get(0)));
        flowFinal.setFinals(new ArrayList<>(fbexp.getHead()));

        return flowFinal;
    }

    @Override
    public Flow visit(TypeTable typeTable) {
        return null;
    }

    @Override
    public Flow visit(TypeType typeType) {
        return null;
    }
}
