// Generated from C:/Users/ionas/Desktop/IONAS/Cours_fac/M2/S1/Analyse_Statique/Enoso/src/main/java/antlr\WhileLanguage.g4 by ANTLR 4.9.2
package parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link WhileLanguageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface WhileLanguageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link WhileLanguageParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(WhileLanguageParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileLanguageParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(WhileLanguageParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileLanguageParser#lDeclIdent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLDeclIdent(WhileLanguageParser.LDeclIdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileLanguageParser#lDeclVariables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLDeclVariables(WhileLanguageParser.LDeclVariablesContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileLanguageParser#declVariables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclVariables(WhileLanguageParser.DeclVariablesContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileLanguageParser#lIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLIdentifier(WhileLanguageParser.LIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeType}
	 * labeled alternative in {@link WhileLanguageParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeType(WhileLanguageParser.TypeTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeTable}
	 * labeled alternative in {@link WhileLanguageParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeTable(WhileLanguageParser.TypeTableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockStatement}
	 * labeled alternative in {@link WhileLanguageParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(WhileLanguageParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockWithinParenthesis}
	 * labeled alternative in {@link WhileLanguageParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockWithinParenthesis(WhileLanguageParser.BlockWithinParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileLanguageParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(WhileLanguageParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementSkip}
	 * labeled alternative in {@link WhileLanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementSkip(WhileLanguageParser.StatementSkipContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementAffectation}
	 * labeled alternative in {@link WhileLanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementAffectation(WhileLanguageParser.StatementAffectationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementIf}
	 * labeled alternative in {@link WhileLanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementIf(WhileLanguageParser.StatementIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementWhile}
	 * labeled alternative in {@link WhileLanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementWhile(WhileLanguageParser.StatementWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementCall}
	 * labeled alternative in {@link WhileLanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementCall(WhileLanguageParser.StatementCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileLanguageParser#lAexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLAexpression(WhileLanguageParser.LAexpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AexpressionArray}
	 * labeled alternative in {@link WhileLanguageParser#aexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAexpressionArray(WhileLanguageParser.AexpressionArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AexpressionParenthesis}
	 * labeled alternative in {@link WhileLanguageParser#aexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAexpressionParenthesis(WhileLanguageParser.AexpressionParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AexpressionIdentifier}
	 * labeled alternative in {@link WhileLanguageParser#aexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAexpressionIdentifier(WhileLanguageParser.AexpressionIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AexpressionNewArray}
	 * labeled alternative in {@link WhileLanguageParser#aexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAexpressionNewArray(WhileLanguageParser.AexpressionNewArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AexpressionConstant}
	 * labeled alternative in {@link WhileLanguageParser#aexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAexpressionConstant(WhileLanguageParser.AexpressionConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AexpressionNeg}
	 * labeled alternative in {@link WhileLanguageParser#aexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAexpressionNeg(WhileLanguageParser.AexpressionNegContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AexpressionBinary}
	 * labeled alternative in {@link WhileLanguageParser#aexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAexpressionBinary(WhileLanguageParser.AexpressionBinaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OpaPlus}
	 * labeled alternative in {@link WhileLanguageParser#opa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpaPlus(WhileLanguageParser.OpaPlusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OpaMinus}
	 * labeled alternative in {@link WhileLanguageParser#opa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpaMinus(WhileLanguageParser.OpaMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OpaMultiplication}
	 * labeled alternative in {@link WhileLanguageParser#opa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpaMultiplication(WhileLanguageParser.OpaMultiplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OpaDivision}
	 * labeled alternative in {@link WhileLanguageParser#opa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpaDivision(WhileLanguageParser.OpaDivisionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BexpressionTrue}
	 * labeled alternative in {@link WhileLanguageParser#bexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBexpressionTrue(WhileLanguageParser.BexpressionTrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BexpressionFalse}
	 * labeled alternative in {@link WhileLanguageParser#bexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBexpressionFalse(WhileLanguageParser.BexpressionFalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BexpressionAexpressionOprAexpression}
	 * labeled alternative in {@link WhileLanguageParser#bexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBexpressionAexpressionOprAexpression(WhileLanguageParser.BexpressionAexpressionOprAexpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BexpressionNot}
	 * labeled alternative in {@link WhileLanguageParser#bexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBexpressionNot(WhileLanguageParser.BexpressionNotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BexpressionParenthesis}
	 * labeled alternative in {@link WhileLanguageParser#bexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBexpressionParenthesis(WhileLanguageParser.BexpressionParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OprLower}
	 * labeled alternative in {@link WhileLanguageParser#opr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOprLower(WhileLanguageParser.OprLowerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OprLowerOrEqual}
	 * labeled alternative in {@link WhileLanguageParser#opr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOprLowerOrEqual(WhileLanguageParser.OprLowerOrEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OprGreater}
	 * labeled alternative in {@link WhileLanguageParser#opr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOprGreater(WhileLanguageParser.OprGreaterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OprGreaterOrEqual}
	 * labeled alternative in {@link WhileLanguageParser#opr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOprGreaterOrEqual(WhileLanguageParser.OprGreaterOrEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OprEqual}
	 * labeled alternative in {@link WhileLanguageParser#opr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOprEqual(WhileLanguageParser.OprEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OprDifferent}
	 * labeled alternative in {@link WhileLanguageParser#opr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOprDifferent(WhileLanguageParser.OprDifferentContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileLanguageParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(WhileLanguageParser.ConstantContext ctx);
}