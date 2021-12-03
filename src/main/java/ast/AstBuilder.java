package ast;


import ast.aexpression.Aexpression;
import ast.aexpression.AexpressionArray;
import ast.aexpression.AexpressionBinary;
import ast.aexpression.AexpressionConstant;
import ast.opa.Opa;
import org.antlr.v4.runtime.ParserRuleContext;
import parser.WhileLanguageBaseVisitor;
import parser.WhileLanguageParser;

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
        return super.visitTypeType(ctx);
    }

    @Override
    public Node visitTypeTable(WhileLanguageParser.TypeTableContext ctx) {
        return super.visitTypeTable(ctx);
    }

    @Override
    public Node visitBlockStatement(WhileLanguageParser.BlockStatementContext ctx) {
        return super.visitBlockStatement(ctx);
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
        return super.visitStatementSkip(ctx);
    }

    @Override
    public Node visitStatementAffectation(WhileLanguageParser.StatementAffectationContext ctx) {
        return super.visitStatementAffectation(ctx);
    }

    @Override
    public Node visitStatementIf(WhileLanguageParser.StatementIfContext ctx) {
        return super.visitStatementIf(ctx);
    }

    @Override
    public Node visitStatementWhile(WhileLanguageParser.StatementWhileContext ctx) {
        return super.visitStatementWhile(ctx);
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
        return super.visitAexpressionParenthesis(ctx);
    }

    @Override
    public Node visitAexpressionIdentifier(WhileLanguageParser.AexpressionIdentifierContext ctx) {
        return super.visitAexpressionIdentifier(ctx);
    }

    @Override
    public Node visitAexpressionUnary(WhileLanguageParser.AexpressionUnaryContext ctx) {
        return super.visitAexpressionUnary(ctx);
    }

    @Override
    public Node visitAexpressionConstant(WhileLanguageParser.AexpressionConstantContext ctx) {
        Position pos = this.makePos(ctx);
        return new AexpressionConstant(pos, Integer.parseInt(ctx.constant().getText()));
    }

    @Override
    public Node visitAexpressionNew(WhileLanguageParser.AexpressionNewContext ctx) {
        return super.visitAexpressionNew(ctx);
    }

    @Override
    public Node visitAexpressionBinary(WhileLanguageParser.AexpressionBinaryContext ctx) {
        return new AexpressionBinary(new Position(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine()), (Aexpression) ctx.aexpression(0).accept(this), (Aexpression) ctx.aexpression(1).accept(this), (Opa) ctx.opa().accept(this));
    }

    @Override
    public Node visitOpaPlus(WhileLanguageParser.OpaPlusContext ctx) {
        return super.visitOpaPlus(ctx);
    }

    @Override
    public Node visitOpaMinus(WhileLanguageParser.OpaMinusContext ctx) {
        return super.visitOpaMinus(ctx);
    }

    @Override
    public Node visitOpaMultiplication(WhileLanguageParser.OpaMultiplicationContext ctx) {
        return super.visitOpaMultiplication(ctx);
    }

    @Override
    public Node visitOpaDivision(WhileLanguageParser.OpaDivisionContext ctx) {
        return super.visitOpaDivision(ctx);
    }

    @Override
    public Node visitBexpressionTrue(WhileLanguageParser.BexpressionTrueContext ctx) {

        return super.visitBexpressionTrue(ctx);
    }

    @Override
    public Node visitBexpressionFalse(WhileLanguageParser.BexpressionFalseContext ctx) {
        return super.visitBexpressionFalse(ctx);
    }

    @Override
    public Node visitBexpressionAexpressionOprAexpression(WhileLanguageParser.BexpressionAexpressionOprAexpressionContext ctx) {
        return super.visitBexpressionAexpressionOprAexpression(ctx);
    }

    @Override
    public Node visitBexpressionNot(WhileLanguageParser.BexpressionNotContext ctx) {
        return super.visitBexpressionNot(ctx);
    }

    @Override
    public Node visitBexpressionParenthesis(WhileLanguageParser.BexpressionParenthesisContext ctx) {
        return super.visitBexpressionParenthesis(ctx);
    }

    @Override
    public Node visitOprLower(WhileLanguageParser.OprLowerContext ctx) {
        return super.visitOprLower(ctx);
    }

    @Override
    public Node visitOprLowerOrEqual(WhileLanguageParser.OprLowerOrEqualContext ctx) {
        return super.visitOprLowerOrEqual(ctx);
    }

    @Override
    public Node visitOprGreater(WhileLanguageParser.OprGreaterContext ctx) {
        return super.visitOprGreater(ctx);
    }

    @Override
    public Node visitOprGreaterOrEqual(WhileLanguageParser.OprGreaterOrEqualContext ctx) {
        return super.visitOprGreaterOrEqual(ctx);
    }

    @Override
    public Node visitOprEqual(WhileLanguageParser.OprEqualContext ctx) {
        return super.visitOprEqual(ctx);
    }

    @Override
    public Node visitOprDifferent(WhileLanguageParser.OprDifferentContext ctx) {
        return super.visitOprDifferent(ctx);
    }

    @Override
    public Node visitConstant(WhileLanguageParser.ConstantContext ctx) {
        return super.visitConstant(ctx);
    }
}
