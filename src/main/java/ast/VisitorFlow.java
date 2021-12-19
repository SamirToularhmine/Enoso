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
import exceptions.InappropriateVisitException;

import java.util.ArrayList;
import java.util.List;

public class VisitorFlow implements Visitor<Flow>{

    @Override
    public Flow visit(Program program) {
        List<Statement> statements = program.getStatements();

        Flow flowFinal = (Flow) statements.get(0).accept(this);

        for (int i = 1; i < statements.size(); i++) {
            Flow nextFlow = (Flow) statements.get(i).accept(this);

            flowFinal.getFinals().forEach(s -> s.getChildren().addAll(nextFlow.getHead()));
            flowFinal.getFinals().clear();
            flowFinal.getFinals().addAll(nextFlow.getFinals());
        }

        return flowFinal;
    }

    @Override
    public Flow visit(DecVariable decVariable) {
        throw new InappropriateVisitException(decVariable);
    }

    @Override
    public Flow visit(Declaration declaration) {
        //TODO
        return null;
    }

    @Override
    public Flow visit(AexpressionArray aexpressionArray) {
        throw new InappropriateVisitException(aexpressionArray);
    }

    @Override
    public Flow visit(AexpressionBinary aexpressionBinary) {
        throw new InappropriateVisitException(aexpressionBinary);
    }

    @Override
    public Flow visit(AexpressionConstant aexpressionConstant) {
        throw new InappropriateVisitException(aexpressionConstant);
    }

    @Override
    public Flow visit(AexpressionIdentifier aexpressionIdentifier) {
        throw new InappropriateVisitException(aexpressionIdentifier);
    }

    @Override
    public Flow visit(AexpressionNewArray aexpressionNewArray) {
        throw new InappropriateVisitException(aexpressionNewArray);
    }

    @Override
    public Flow visit(AexpressionParenthesis aexpressionParenthesis) {
        throw new InappropriateVisitException(aexpressionParenthesis);
    }

    @Override
    public Flow visit(AexpressionNeg aexpressionUnary) {
        throw new InappropriateVisitException(aexpressionUnary);
    }

    @Override
    public Flow visit(BexpressionAexpressionOprAexpression bexpressionAexpressionOprAexpression) {
        Flow flowFinal = new Flow();

        State state = new State(bexpressionAexpressionOprAexpression, -1, new ArrayList<>(), new ArrayList<>());
        flowFinal.getHead().add(state);
        flowFinal.getFinals().add(state);

        return flowFinal;
    }

    @Override
    public Flow visit(BexpressionConst bexpressionConst) {
        Flow flowFinal = new Flow();

        State state = new State(bexpressionConst, -1, new ArrayList<>(), new ArrayList<>());
        flowFinal.getHead().add(state);
        flowFinal.getFinals().add(state);

        return flowFinal;
    }

    @Override
    public Flow visit(BexpressionNot bexpressionNot) {
        return (Flow) bexpressionNot.getValue().accept(this);
    }

    @Override
    public Flow visit(BexpressionParenthesis bexpressionParenthesis) {
        return (Flow) bexpressionParenthesis.getValue().accept(this);
    }

    @Override
    public Flow visit(BlockStatement blockStatement) {
        Flow flowFinal = new Flow();

        State state = new State(blockStatement.getStatement(), -1, new ArrayList<>(), new ArrayList<>());
        flowFinal.getHead().add(state);
        flowFinal.getFinals().add(state);

        return flowFinal;
    }

    @Override
    public Flow visit(BlockWithinParenthesis blockWithinParenthesis) {
        List<Statement> statements = blockWithinParenthesis.getStatements();
        Flow flowFinal = (Flow) statements.get(0).accept(this);
        for (int i = 1; i < blockWithinParenthesis.getStatements().size(); i++) {
            Flow nextFlow = (Flow) statements.get(i).accept(this);
            flowFinal.getFinals().forEach(s -> s.getChildren().addAll(nextFlow.getHead()));
            flowFinal.getFinals().clear();
            flowFinal.getFinals().addAll(nextFlow.getFinals());
        }
        return flowFinal;
    }

    @Override
    public Flow visit(OpaValue opaDivision) {
        throw new InappropriateVisitException(opaDivision);
    }

    @Override
    public Flow visit(OprValue oprValue) {
        throw new InappropriateVisitException(oprValue);
    }

    @Override
    public Flow visit(StatementAffectation statementAffectation) {
        Flow flowFinal = new Flow();

        State state = new State(statementAffectation, -1, new ArrayList<>(), new ArrayList<>());
        flowFinal.getHead().add(state);
        flowFinal.getFinals().add(state);

        return flowFinal;
    }

    @Override
    public Flow visit(StatementCall statementCall) {
        // @TODO
        return null;
    }

    @Override
    public Flow visit(StatementIf statementIf) {
        Flow flowFinal = new Flow();

        Flow flowCond = (Flow) statementIf.getCondition().accept(this);
        Flow flowIfBlock = (Flow) statementIf.getIfBlock().accept(this);
        Flow flowElseBlock;

        flowFinal.getHead().addAll(flowCond.getHead());
        flowFinal.getFinals().addAll(flowIfBlock.getFinals());
        flowFinal.getHead().get(0).getChildren().addAll(flowIfBlock.getHead());

        // Il peut ne pas y avoir de else block
        if(statementIf.getElseBlock() != null){
            flowElseBlock = (Flow) statementIf.getElseBlock().accept(this);
            flowFinal.getFinals().addAll(flowElseBlock.getFinals());
            flowFinal.getHead().get(0).getChildren().addAll(flowElseBlock.getHead());
        }else{
            flowFinal.getFinals().add(flowFinal.getHead().get(0));
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

        flowFinal.getHead().addAll(fbexp.getHead());
        fblock.getFinals().forEach(s -> s.getChildren().addAll(flowFinal.getHead()));
        flowFinal.getHead().get(0).getChildren().add(fblock.getHead().get(0));
        flowFinal.getFinals().addAll(fbexp.getHead());

        return flowFinal;
    }

    @Override
    public Flow visit(TypeTable typeTable) {
        throw new InappropriateVisitException(typeTable);
    }

    @Override
    public Flow visit(TypeType typeType) {
        throw new InappropriateVisitException(typeType);
    }
}
