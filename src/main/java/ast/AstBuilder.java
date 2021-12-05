package ast;


import ast.aexpression.*;
import ast.bexpression.*;
import ast.block.Block;
import ast.block.BlockStatement;
import ast.block.BlockWithinParenthesis;
import ast.opa.Opa;
import ast.opa.OpaValue;
import ast.opr.Opr;
import ast.opr.OprValue;
import ast.statement.*;
import ast.type.Type;
import ast.type.TypeTable;
import ast.type.TypeType;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import parser.WhileLanguageBaseVisitor;
import parser.WhileLanguageParser;

import java.util.ArrayList;
import java.util.List;

public class AstBuilder extends WhileLanguageBaseVisitor<Node> {

    private Position makePos(ParserRuleContext ctx) {
        return new Position(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    private String getOpString(TerminalNode terminalNode){
        return terminalNode.getSymbol().getText();
    }

    @Override
    public Node visitProgram(WhileLanguageParser.ProgramContext ctx) {
        String programName = "";
        if(ctx.Identifier() != null){
            programName = ctx.Identifier().getSymbol().getText();
        }
        List<Declaration> declarationList = new ArrayList<>(); // La déclaration des procs (avant le begin)
        for (int i = 0; i < ctx.declaration().size(); i++){
            declarationList.add((Declaration) ctx.declaration(i).accept(this));
        }
        List<DecVariable> decVariableList = new ArrayList<>(); // Déclaration des variables
        decVariableList.add((DecVariable) ctx.lDeclVariables().declVariables().accept(this));
        for(int i = 0; i < ctx.lDeclVariables().lDeclVariables().size(); i++){
            DecVariable decVariable = (DecVariable) ctx.lDeclVariables().lDeclVariables(i).accept(this);
            decVariableList.add(decVariable);
        }

        Program program = new Program(this.makePos(ctx),programName, declarationList, decVariableList, null);
        return program;
    }

    @Override
    public Node visitDeclaration(WhileLanguageParser.DeclarationContext ctx) {
        return super.visitDeclaration(ctx);
    }

    @Override
    public Node visitLDeclIdent(WhileLanguageParser.LDeclIdentContext ctx) {
        return super.visitLDeclIdent(ctx);
    }

    @Override
    public Node visitLDeclVariables(WhileLanguageParser.LDeclVariablesContext ctx) {
        return super.visitLDeclVariables(ctx);
    }

    @Override
    public Node visitDeclVariables(WhileLanguageParser.DeclVariablesContext ctx) {
        Type type = (Type) ctx.type().accept(this);

        List<String> identifiers = new ArrayList<>();
        for(int i = 0; i < ctx.lIdentifier().Identifier().size(); i++){
            identifiers.add(ctx.lIdentifier().Identifier(i).getSymbol().getText());
        }
        return new DecVariable(this.makePos(ctx), type, identifiers);
    }

    @Override
    public Node visitLIdentifier(WhileLanguageParser.LIdentifierContext ctx) {
        return super.visitLIdentifier(ctx);
    }

    @Override
    public Node visitTypeType(WhileLanguageParser.TypeTypeContext ctx) {
        Position position = this.makePos(ctx);
        String value = ctx.Type().getSymbol().getText();
        return new TypeType(position, value);
    }

    @Override
    public Node visitTypeTable(WhileLanguageParser.TypeTableContext ctx) {
        Position position = this.makePos(ctx);
        //A vérifier todo
        TypeType type = (TypeType) ctx.Table().getChild(0).accept(this);
        return new TypeTable(position, type);
    }

    @Override
    public Node visitBlockStatement(WhileLanguageParser.BlockStatementContext ctx) {
        Position position = this.makePos(ctx);
        return new BlockStatement(position, (Statement) ctx.statement().accept(this));
    }

    @Override
    public Node visitBlockWithinParenthesis(WhileLanguageParser.BlockWithinParenthesisContext ctx) {
        return super.visitBlockWithinParenthesis(ctx);
    }

    @Override
    public Node visitStatements(WhileLanguageParser.StatementsContext ctx) {
        return super.visitStatements(ctx);
    }

    @Override
    public Node visitStatementSkip(WhileLanguageParser.StatementSkipContext ctx) {
        Position pos = this.makePos(ctx);
        return new StatementSkip(pos);
    }

    @Override
    public Node visitStatementAffectation(WhileLanguageParser.StatementAffectationContext ctx) {
        Position pos = this.makePos(ctx);
        return new StatementAffectation(pos, ctx.Identifier().getText(), (Aexpression) ctx.aexpression().accept(this));
    }

    @Override
    public Node visitStatementIf(WhileLanguageParser.StatementIfContext ctx) {
        Position pos = this.makePos(ctx);
        return new StatementIf(pos, (Bexpression) ctx.bexpression().accept(this), (Block) ctx.block(0).accept(this), (Block) ctx.block(1).accept(this));
    }

    @Override
    public Node visitStatementWhile(WhileLanguageParser.StatementWhileContext ctx) {
        Position pos = this.makePos(ctx);
        return new StatementWhile(pos, (Bexpression) ctx.bexpression().accept(this), (Block) ctx.block().accept(this));
    }

    @Override
    public Node visitStatementCall(WhileLanguageParser.StatementCallContext ctx) {
        return super.visitStatementCall(ctx);
    }

    @Override
    public Node visitLAexpression(WhileLanguageParser.LAexpressionContext ctx) {
        return super.visitLAexpression(ctx);
    }

    @Override
    public Node visitAexpressionArray(WhileLanguageParser.AexpressionArrayContext ctx) {
        Position pos = this.makePos(ctx);
        return new AexpressionArray(pos, ctx.Identifier().getText(), (Aexpression) ctx.aexpression().accept(this));
    }

    @Override
    public Node visitAexpressionParenthesis(WhileLanguageParser.AexpressionParenthesisContext ctx) {
        Position pos = this.makePos(ctx);
        return new AexpressionParenthesis(pos, (Aexpression) ctx.aexpression().accept(this));
    }

    @Override
    public Node visitAexpressionIdentifier(WhileLanguageParser.AexpressionIdentifierContext ctx) {
        Position pos = this.makePos(ctx);
        return new AexpressionIdentifier(pos, ctx.Identifier().getSymbol().getText() );
    }

    @Override
    public Node visitAexpressionUnary(WhileLanguageParser.AexpressionUnaryContext ctx) {
        Position pos = this.makePos(ctx);
        return super.visitAexpressionUnary(ctx);
    }

    @Override
    public Node visitAexpressionConstant(WhileLanguageParser.AexpressionConstantContext ctx) {
        Position pos = this.makePos(ctx);
        return new AexpressionConstant(pos, Integer.parseInt(ctx.constant().getText()));
    }

    @Override
    public Node visitAexpressionNew(WhileLanguageParser.AexpressionNewContext ctx) {
        Position pos = this.makePos(ctx);
        return new AexpressionNew(pos,(Type) ctx.Type().accept(this), (Aexpression) ctx.aexpression().accept(this) );
    }

    @Override
    public Node visitAexpressionBinary(WhileLanguageParser.AexpressionBinaryContext ctx) {
        Position position = this.makePos(ctx);
        return new AexpressionBinary(position, (Aexpression) ctx.aexpression(0).accept(this), (Aexpression) ctx.aexpression(1).accept(this), (Opa) ctx.opa().accept(this));
    }

    @Override
    public Node visitOpaPlus(WhileLanguageParser.OpaPlusContext ctx) {
        Position pos = this.makePos(ctx);
        return new OpaValue(pos, this.getOpString(ctx.Plus()));
    }

    @Override
    public Node visitOpaMinus(WhileLanguageParser.OpaMinusContext ctx) {
        Position pos = this.makePos(ctx);
        return new OpaValue(pos, this.getOpString(ctx.Minus()));
    }

    @Override
    public Node visitOpaMultiplication(WhileLanguageParser.OpaMultiplicationContext ctx) {
        Position pos = this.makePos(ctx);
        return new OpaValue(pos, this.getOpString(ctx.Multiplication()));
    }

    @Override
    public Node visitOpaDivision(WhileLanguageParser.OpaDivisionContext ctx) {
        Position pos = this.makePos(ctx);
        return new OpaValue(pos, this.getOpString(ctx.Division()));
    }

    @Override
    public Node visitBexpressionTrue(WhileLanguageParser.BexpressionTrueContext ctx) {
        Position pos = this.makePos(ctx);
        return new BexpressionConst(pos, true);
    }

    @Override
    public Node visitBexpressionFalse(WhileLanguageParser.BexpressionFalseContext ctx) {
        Position pos = this.makePos(ctx);
        return new BexpressionConst(pos, false);
    }

    @Override
    public Node visitBexpressionAexpressionOprAexpression(WhileLanguageParser.BexpressionAexpressionOprAexpressionContext ctx) {
        Position pos = this.makePos(ctx);
        return new BexpressionAexpressionOprAexpression(pos, (Aexpression) ctx.aexpression(0).accept(this), (Aexpression) ctx.aexpression(1).accept(this), (Opr) ctx.opr().accept(this));
    }

    @Override
    public Node visitBexpressionNot(WhileLanguageParser.BexpressionNotContext ctx) {
        Position pos = this.makePos(ctx);
        return new BexpressionNot(pos, (Bexpression) ctx.bexpression().accept(this));
    }

    @Override
    public Node visitBexpressionParenthesis(WhileLanguageParser.BexpressionParenthesisContext ctx) {
        Position pos = this.makePos(ctx);
        return new BexpressionParenthesis(pos, (Bexpression) ctx.bexpression().accept(this));
    }

    @Override
    public Node visitOprLower(WhileLanguageParser.OprLowerContext ctx) {
        Position pos = this.makePos(ctx);
        return new OprValue(pos, this.getOpString(ctx.Lower()));
    }

    @Override
    public Node visitOprLowerOrEqual(WhileLanguageParser.OprLowerOrEqualContext ctx) {
        Position pos = this.makePos(ctx);
        return new OprValue(pos, this.getOpString(ctx.LowerOrEqual()));
    }

    @Override
    public Node visitOprGreater(WhileLanguageParser.OprGreaterContext ctx) {
        Position pos = this.makePos(ctx);
        return new OprValue(pos, this.getOpString(ctx.Greater()));
    }

    @Override
    public Node visitOprGreaterOrEqual(WhileLanguageParser.OprGreaterOrEqualContext ctx) {
        Position pos = this.makePos(ctx);
        return new OprValue(pos, this.getOpString(ctx.GreaterOrEqual()));
    }

    @Override
    public Node visitOprEqual(WhileLanguageParser.OprEqualContext ctx) {
        Position pos = this.makePos(ctx);
        return new OprValue(pos, this.getOpString(ctx.Equal()));
    }

    @Override
    public Node visitOprDifferent(WhileLanguageParser.OprDifferentContext ctx) {
        Position pos = this.makePos(ctx);
        return new OprValue(pos, this.getOpString(ctx.Different()));
    }

    @Override
    public Node visitConstant(WhileLanguageParser.ConstantContext ctx) {
        return super.visitConstant(ctx);
    }
}
