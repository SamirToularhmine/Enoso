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
import parser.WhileLanguageBaseVisitor;
import parser.WhileLanguageParser;

import java.util.List;

public class AstBuilder extends WhileLanguageBaseVisitor<Node> {

    private Position makePos(ParserRuleContext ctx) {
        return new Position(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Node visitProgram(WhileLanguageParser.ProgramContext ctx) {
        return super.visitProgram(ctx);
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
        return super.visitDeclVariables(ctx);
    }

    @Override
    public Node visitLIdentifier(WhileLanguageParser.LIdentifierContext ctx) {
        return super.visitLIdentifier(ctx);
    }

    @Override
    public Node visitTypeType(WhileLanguageParser.TypeTypeContext ctx) {
        Position position = this.makePos(ctx);
        return new TypeType(position);
    }

    @Override
    public Node visitTypeTable(WhileLanguageParser.TypeTableContext ctx) {
        Position position = this.makePos(ctx);
        return new TypeTable(position);
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
        return new StatementWhile(pos, (Bexpression) ctx.bexpression().accept(this), (Block) ctx.bexpression().accept(this));
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
        return new AexpressionIdentifier(pos, ctx.Identifier().accept(this).toString() );
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
        return new OpaValue(pos, "+");
    }

    @Override
    public Node visitOpaMinus(WhileLanguageParser.OpaMinusContext ctx) {
        Position pos = this.makePos(ctx);
        return new OpaValue(pos, "-");
    }

    @Override
    public Node visitOpaMultiplication(WhileLanguageParser.OpaMultiplicationContext ctx) {
        Position pos = this.makePos(ctx);
        return new OpaValue(pos, "*");
    }

    @Override
    public Node visitOpaDivision(WhileLanguageParser.OpaDivisionContext ctx) {
        Position pos = this.makePos(ctx);
        return new OpaValue(pos, "/");
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
        return new OprValue(pos, "<");
    }

    @Override
    public Node visitOprLowerOrEqual(WhileLanguageParser.OprLowerOrEqualContext ctx) {
        Position pos = this.makePos(ctx);
        return new OprValue(pos, "<=");
    }

    @Override
    public Node visitOprGreater(WhileLanguageParser.OprGreaterContext ctx) {
        Position pos = this.makePos(ctx);
        return new OprValue(pos, ">");
    }

    @Override
    public Node visitOprGreaterOrEqual(WhileLanguageParser.OprGreaterOrEqualContext ctx) {
        Position pos = this.makePos(ctx);
        return new OprValue(pos, ">=");
    }

    @Override
    public Node visitOprEqual(WhileLanguageParser.OprEqualContext ctx) {
        Position pos = this.makePos(ctx);
        return new OprValue(pos, "==");
    }

    @Override
    public Node visitOprDifferent(WhileLanguageParser.OprDifferentContext ctx) {
        Position pos = this.makePos(ctx);
        return new OprValue(pos, "!=");
    }

    @Override
    public Node visitConstant(WhileLanguageParser.ConstantContext ctx) {
        return super.visitConstant(ctx);
    }
}
