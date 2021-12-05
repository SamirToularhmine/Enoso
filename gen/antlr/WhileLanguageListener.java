// Generated from E:/Enoso/src/main/java/antlr\WhileLanguage.g4 by ANTLR 4.9.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link WhileLanguageParser}.
 */
public interface WhileLanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link WhileLanguageParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(WhileLanguageParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileLanguageParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(WhileLanguageParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileLanguageParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(WhileLanguageParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileLanguageParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(WhileLanguageParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileLanguageParser#lDeclIdent}.
	 * @param ctx the parse tree
	 */
	void enterLDeclIdent(WhileLanguageParser.LDeclIdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileLanguageParser#lDeclIdent}.
	 * @param ctx the parse tree
	 */
	void exitLDeclIdent(WhileLanguageParser.LDeclIdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileLanguageParser#lDeclVariables}.
	 * @param ctx the parse tree
	 */
	void enterLDeclVariables(WhileLanguageParser.LDeclVariablesContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileLanguageParser#lDeclVariables}.
	 * @param ctx the parse tree
	 */
	void exitLDeclVariables(WhileLanguageParser.LDeclVariablesContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileLanguageParser#declVariables}.
	 * @param ctx the parse tree
	 */
	void enterDeclVariables(WhileLanguageParser.DeclVariablesContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileLanguageParser#declVariables}.
	 * @param ctx the parse tree
	 */
	void exitDeclVariables(WhileLanguageParser.DeclVariablesContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileLanguageParser#lIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterLIdentifier(WhileLanguageParser.LIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileLanguageParser#lIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitLIdentifier(WhileLanguageParser.LIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeType}
	 * labeled alternative in {@link WhileLanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeType(WhileLanguageParser.TypeTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeType}
	 * labeled alternative in {@link WhileLanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeType(WhileLanguageParser.TypeTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeTable}
	 * labeled alternative in {@link WhileLanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeTable(WhileLanguageParser.TypeTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeTable}
	 * labeled alternative in {@link WhileLanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeTable(WhileLanguageParser.TypeTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockStatement}
	 * labeled alternative in {@link WhileLanguageParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(WhileLanguageParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockStatement}
	 * labeled alternative in {@link WhileLanguageParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(WhileLanguageParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockWithinParenthesis}
	 * labeled alternative in {@link WhileLanguageParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlockWithinParenthesis(WhileLanguageParser.BlockWithinParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockWithinParenthesis}
	 * labeled alternative in {@link WhileLanguageParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlockWithinParenthesis(WhileLanguageParser.BlockWithinParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileLanguageParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(WhileLanguageParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileLanguageParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(WhileLanguageParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementSkip}
	 * labeled alternative in {@link WhileLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementSkip(WhileLanguageParser.StatementSkipContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementSkip}
	 * labeled alternative in {@link WhileLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementSkip(WhileLanguageParser.StatementSkipContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementAffectation}
	 * labeled alternative in {@link WhileLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementAffectation(WhileLanguageParser.StatementAffectationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementAffectation}
	 * labeled alternative in {@link WhileLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementAffectation(WhileLanguageParser.StatementAffectationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementIf}
	 * labeled alternative in {@link WhileLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementIf(WhileLanguageParser.StatementIfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementIf}
	 * labeled alternative in {@link WhileLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementIf(WhileLanguageParser.StatementIfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementWhile}
	 * labeled alternative in {@link WhileLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementWhile(WhileLanguageParser.StatementWhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementWhile}
	 * labeled alternative in {@link WhileLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementWhile(WhileLanguageParser.StatementWhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementCall}
	 * labeled alternative in {@link WhileLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementCall(WhileLanguageParser.StatementCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementCall}
	 * labeled alternative in {@link WhileLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementCall(WhileLanguageParser.StatementCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileLanguageParser#lAexpression}.
	 * @param ctx the parse tree
	 */
	void enterLAexpression(WhileLanguageParser.LAexpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileLanguageParser#lAexpression}.
	 * @param ctx the parse tree
	 */
	void exitLAexpression(WhileLanguageParser.LAexpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AexpressionArray}
	 * labeled alternative in {@link WhileLanguageParser#aexpression}.
	 * @param ctx the parse tree
	 */
	void enterAexpressionArray(WhileLanguageParser.AexpressionArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AexpressionArray}
	 * labeled alternative in {@link WhileLanguageParser#aexpression}.
	 * @param ctx the parse tree
	 */
	void exitAexpressionArray(WhileLanguageParser.AexpressionArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AexpressionParenthesis}
	 * labeled alternative in {@link WhileLanguageParser#aexpression}.
	 * @param ctx the parse tree
	 */
	void enterAexpressionParenthesis(WhileLanguageParser.AexpressionParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AexpressionParenthesis}
	 * labeled alternative in {@link WhileLanguageParser#aexpression}.
	 * @param ctx the parse tree
	 */
	void exitAexpressionParenthesis(WhileLanguageParser.AexpressionParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AexpressionIdentifier}
	 * labeled alternative in {@link WhileLanguageParser#aexpression}.
	 * @param ctx the parse tree
	 */
	void enterAexpressionIdentifier(WhileLanguageParser.AexpressionIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AexpressionIdentifier}
	 * labeled alternative in {@link WhileLanguageParser#aexpression}.
	 * @param ctx the parse tree
	 */
	void exitAexpressionIdentifier(WhileLanguageParser.AexpressionIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AexpressionConstant}
	 * labeled alternative in {@link WhileLanguageParser#aexpression}.
	 * @param ctx the parse tree
	 */
	void enterAexpressionConstant(WhileLanguageParser.AexpressionConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AexpressionConstant}
	 * labeled alternative in {@link WhileLanguageParser#aexpression}.
	 * @param ctx the parse tree
	 */
	void exitAexpressionConstant(WhileLanguageParser.AexpressionConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AexpressionNeg}
	 * labeled alternative in {@link WhileLanguageParser#aexpression}.
	 * @param ctx the parse tree
	 */
	void enterAexpressionNeg(WhileLanguageParser.AexpressionNegContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AexpressionNeg}
	 * labeled alternative in {@link WhileLanguageParser#aexpression}.
	 * @param ctx the parse tree
	 */
	void exitAexpressionNeg(WhileLanguageParser.AexpressionNegContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AexpressionNew}
	 * labeled alternative in {@link WhileLanguageParser#aexpression}.
	 * @param ctx the parse tree
	 */
	void enterAexpressionNew(WhileLanguageParser.AexpressionNewContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AexpressionNew}
	 * labeled alternative in {@link WhileLanguageParser#aexpression}.
	 * @param ctx the parse tree
	 */
	void exitAexpressionNew(WhileLanguageParser.AexpressionNewContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AexpressionBinary}
	 * labeled alternative in {@link WhileLanguageParser#aexpression}.
	 * @param ctx the parse tree
	 */
	void enterAexpressionBinary(WhileLanguageParser.AexpressionBinaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AexpressionBinary}
	 * labeled alternative in {@link WhileLanguageParser#aexpression}.
	 * @param ctx the parse tree
	 */
	void exitAexpressionBinary(WhileLanguageParser.AexpressionBinaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OpaPlus}
	 * labeled alternative in {@link WhileLanguageParser#opa}.
	 * @param ctx the parse tree
	 */
	void enterOpaPlus(WhileLanguageParser.OpaPlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OpaPlus}
	 * labeled alternative in {@link WhileLanguageParser#opa}.
	 * @param ctx the parse tree
	 */
	void exitOpaPlus(WhileLanguageParser.OpaPlusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OpaMinus}
	 * labeled alternative in {@link WhileLanguageParser#opa}.
	 * @param ctx the parse tree
	 */
	void enterOpaMinus(WhileLanguageParser.OpaMinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OpaMinus}
	 * labeled alternative in {@link WhileLanguageParser#opa}.
	 * @param ctx the parse tree
	 */
	void exitOpaMinus(WhileLanguageParser.OpaMinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OpaMultiplication}
	 * labeled alternative in {@link WhileLanguageParser#opa}.
	 * @param ctx the parse tree
	 */
	void enterOpaMultiplication(WhileLanguageParser.OpaMultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OpaMultiplication}
	 * labeled alternative in {@link WhileLanguageParser#opa}.
	 * @param ctx the parse tree
	 */
	void exitOpaMultiplication(WhileLanguageParser.OpaMultiplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OpaDivision}
	 * labeled alternative in {@link WhileLanguageParser#opa}.
	 * @param ctx the parse tree
	 */
	void enterOpaDivision(WhileLanguageParser.OpaDivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OpaDivision}
	 * labeled alternative in {@link WhileLanguageParser#opa}.
	 * @param ctx the parse tree
	 */
	void exitOpaDivision(WhileLanguageParser.OpaDivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BexpressionTrue}
	 * labeled alternative in {@link WhileLanguageParser#bexpression}.
	 * @param ctx the parse tree
	 */
	void enterBexpressionTrue(WhileLanguageParser.BexpressionTrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BexpressionTrue}
	 * labeled alternative in {@link WhileLanguageParser#bexpression}.
	 * @param ctx the parse tree
	 */
	void exitBexpressionTrue(WhileLanguageParser.BexpressionTrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BexpressionFalse}
	 * labeled alternative in {@link WhileLanguageParser#bexpression}.
	 * @param ctx the parse tree
	 */
	void enterBexpressionFalse(WhileLanguageParser.BexpressionFalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BexpressionFalse}
	 * labeled alternative in {@link WhileLanguageParser#bexpression}.
	 * @param ctx the parse tree
	 */
	void exitBexpressionFalse(WhileLanguageParser.BexpressionFalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BexpressionAexpressionOprAexpression}
	 * labeled alternative in {@link WhileLanguageParser#bexpression}.
	 * @param ctx the parse tree
	 */
	void enterBexpressionAexpressionOprAexpression(WhileLanguageParser.BexpressionAexpressionOprAexpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BexpressionAexpressionOprAexpression}
	 * labeled alternative in {@link WhileLanguageParser#bexpression}.
	 * @param ctx the parse tree
	 */
	void exitBexpressionAexpressionOprAexpression(WhileLanguageParser.BexpressionAexpressionOprAexpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BexpressionNot}
	 * labeled alternative in {@link WhileLanguageParser#bexpression}.
	 * @param ctx the parse tree
	 */
	void enterBexpressionNot(WhileLanguageParser.BexpressionNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BexpressionNot}
	 * labeled alternative in {@link WhileLanguageParser#bexpression}.
	 * @param ctx the parse tree
	 */
	void exitBexpressionNot(WhileLanguageParser.BexpressionNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BexpressionParenthesis}
	 * labeled alternative in {@link WhileLanguageParser#bexpression}.
	 * @param ctx the parse tree
	 */
	void enterBexpressionParenthesis(WhileLanguageParser.BexpressionParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BexpressionParenthesis}
	 * labeled alternative in {@link WhileLanguageParser#bexpression}.
	 * @param ctx the parse tree
	 */
	void exitBexpressionParenthesis(WhileLanguageParser.BexpressionParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OprLower}
	 * labeled alternative in {@link WhileLanguageParser#opr}.
	 * @param ctx the parse tree
	 */
	void enterOprLower(WhileLanguageParser.OprLowerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OprLower}
	 * labeled alternative in {@link WhileLanguageParser#opr}.
	 * @param ctx the parse tree
	 */
	void exitOprLower(WhileLanguageParser.OprLowerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OprLowerOrEqual}
	 * labeled alternative in {@link WhileLanguageParser#opr}.
	 * @param ctx the parse tree
	 */
	void enterOprLowerOrEqual(WhileLanguageParser.OprLowerOrEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OprLowerOrEqual}
	 * labeled alternative in {@link WhileLanguageParser#opr}.
	 * @param ctx the parse tree
	 */
	void exitOprLowerOrEqual(WhileLanguageParser.OprLowerOrEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OprGreater}
	 * labeled alternative in {@link WhileLanguageParser#opr}.
	 * @param ctx the parse tree
	 */
	void enterOprGreater(WhileLanguageParser.OprGreaterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OprGreater}
	 * labeled alternative in {@link WhileLanguageParser#opr}.
	 * @param ctx the parse tree
	 */
	void exitOprGreater(WhileLanguageParser.OprGreaterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OprGreaterOrEqual}
	 * labeled alternative in {@link WhileLanguageParser#opr}.
	 * @param ctx the parse tree
	 */
	void enterOprGreaterOrEqual(WhileLanguageParser.OprGreaterOrEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OprGreaterOrEqual}
	 * labeled alternative in {@link WhileLanguageParser#opr}.
	 * @param ctx the parse tree
	 */
	void exitOprGreaterOrEqual(WhileLanguageParser.OprGreaterOrEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OprEqual}
	 * labeled alternative in {@link WhileLanguageParser#opr}.
	 * @param ctx the parse tree
	 */
	void enterOprEqual(WhileLanguageParser.OprEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OprEqual}
	 * labeled alternative in {@link WhileLanguageParser#opr}.
	 * @param ctx the parse tree
	 */
	void exitOprEqual(WhileLanguageParser.OprEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OprDifferent}
	 * labeled alternative in {@link WhileLanguageParser#opr}.
	 * @param ctx the parse tree
	 */
	void enterOprDifferent(WhileLanguageParser.OprDifferentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OprDifferent}
	 * labeled alternative in {@link WhileLanguageParser#opr}.
	 * @param ctx the parse tree
	 */
	void exitOprDifferent(WhileLanguageParser.OprDifferentContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileLanguageParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(WhileLanguageParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileLanguageParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(WhileLanguageParser.ConstantContext ctx);
}