/* (C) Brady Russell 2022 */
package com.bradyrussell.uiscoin.lang.generated;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link UISCParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface UISCVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link UISCParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(UISCParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link UISCParser#pointer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPointer(UISCParser.PointerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varInitialization}
	 * labeled alternative in {@link UISCParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarInitialization(UISCParser.VarInitializationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayValueInitialization}
	 * labeled alternative in {@link UISCParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayValueInitialization(UISCParser.ArrayValueInitializationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayStringInitialization}
	 * labeled alternative in {@link UISCParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayStringInitialization(UISCParser.ArrayStringInitializationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayAssignmentInitialization}
	 * labeled alternative in {@link UISCParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAssignmentInitialization(UISCParser.ArrayAssignmentInitializationContext ctx);
	/**
	 * Visit a parse tree produced by {@link UISCParser#structDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDeclaration(UISCParser.StructDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link UISCParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(UISCParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link UISCParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(UISCParser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link UISCParser#structType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructType(UISCParser.StructTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link UISCParser#tupleType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTupleType(UISCParser.TupleTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link UISCParser#inferredType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInferredType(UISCParser.InferredTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link UISCParser#booleanLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(UISCParser.BooleanLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link UISCParser#arrayInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInitializer(UISCParser.ArrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link UISCParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(UISCParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link UISCParser#formalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameters(UISCParser.FormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link UISCParser#formalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameter(UISCParser.FormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link UISCParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(UISCParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(UISCParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varDeclarationStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclarationStatement(UISCParser.VarDeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code structDeclarationStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDeclarationStatement(UISCParser.StructDeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(UISCParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code uforiStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUforiStatement(UISCParser.UforiStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code uforeachStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUforeachStatement(UISCParser.UforeachStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(UISCParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(UISCParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(UISCParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignmentStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(UISCParser.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code opAndAssignmentStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpAndAssignmentStatement(UISCParser.OpAndAssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tryCatchStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryCatchStatement(UISCParser.TryCatchStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionCallStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallStatement(UISCParser.FunctionCallStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assemblyStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssemblyStatement(UISCParser.AssemblyStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assertionStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssertionStatement(UISCParser.AssertionStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exceptionStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionStatement(UISCParser.ExceptionStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code includeStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncludeStatement(UISCParser.IncludeStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code flagStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlagStatement(UISCParser.FlagStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code flagDataStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlagDataStatement(UISCParser.FlagDataStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code breakStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(UISCParser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code continueStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(UISCParser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UISCParser#elseifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseifStatement(UISCParser.ElseifStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UISCParser#elseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStatement(UISCParser.ElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UISCParser#tryStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryStatement(UISCParser.TryStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UISCParser#catchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchStatement(UISCParser.CatchStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UISCParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(UISCParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link UISCParser#assembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssembly(UISCParser.AssemblyContext ctx);
	/**
	 * Visit a parse tree produced by {@link UISCParser#assertion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssertion(UISCParser.AssertionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UISCParser#exception}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitException(UISCParser.ExceptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UISCParser#include}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInclude(UISCParser.IncludeContext ctx);
	/**
	 * Visit a parse tree produced by {@link UISCParser#flag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlag(UISCParser.FlagContext ctx);
	/**
	 * Visit a parse tree produced by {@link UISCParser#flagData}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlagData(UISCParser.FlagDataContext ctx);
	/**
	 * Visit a parse tree produced by {@link UISCParser#structField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructField(UISCParser.StructFieldContext ctx);
	/**
	 * Visit a parse tree produced by the {@code postfixOpExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixOpExpression(UISCParser.PostfixOpExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code moduloExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuloExpression(UISCParser.ModuloExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multDivExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultDivExpression(UISCParser.MultDivExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpression(UISCParser.NotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prefixOpExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixOpExpression(UISCParser.PrefixOpExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanLiteralExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteralExpression(UISCParser.BooleanLiteralExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparisonExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpression(UISCParser.ComparisonExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpression(UISCParser.ParenExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberLiteralExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberLiteralExpression(UISCParser.NumberLiteralExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valueAtVariableExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueAtVariableExpression(UISCParser.ValueAtVariableExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code castExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastExpression(UISCParser.CastExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nativeCallExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNativeCallExpression(UISCParser.NativeCallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tupleExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTupleExpression(UISCParser.TupleExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sizeOfExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSizeOfExpression(UISCParser.SizeOfExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpression(UISCParser.FunctionCallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bitwiseExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseExpression(UISCParser.BitwiseExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negateExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegateExpression(UISCParser.NegateExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addressOfVariableExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddressOfVariableExpression(UISCParser.AddressOfVariableExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lengthOfExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLengthOfExpression(UISCParser.LengthOfExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code structFieldReferenceExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructFieldReferenceExpression(UISCParser.StructFieldReferenceExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringLiteralExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteralExpression(UISCParser.StringLiteralExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayAccessExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccessExpression(UISCParser.ArrayAccessExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableReferenceExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableReferenceExpression(UISCParser.VariableReferenceExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSubExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubExpression(UISCParser.AddSubExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andOrXorExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndOrXorExpression(UISCParser.AndOrXorExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalityExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(UISCParser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charLiteralExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharLiteralExpression(UISCParser.CharLiteralExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ternaryExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernaryExpression(UISCParser.TernaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UISCParser#exprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprList(UISCParser.ExprListContext ctx);
}