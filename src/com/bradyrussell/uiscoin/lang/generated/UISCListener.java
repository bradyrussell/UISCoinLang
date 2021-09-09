/* (C) Brady Russell 2021 */
package com.bradyrussell.uiscoin.lang.generated;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link UISCParser}.
 */
public interface UISCListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link UISCParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(UISCParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link UISCParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(UISCParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link UISCParser#pointer}.
	 * @param ctx the parse tree
	 */
	void enterPointer(UISCParser.PointerContext ctx);
	/**
	 * Exit a parse tree produced by {@link UISCParser#pointer}.
	 * @param ctx the parse tree
	 */
	void exitPointer(UISCParser.PointerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varInitialization}
	 * labeled alternative in {@link UISCParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarInitialization(UISCParser.VarInitializationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varInitialization}
	 * labeled alternative in {@link UISCParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarInitialization(UISCParser.VarInitializationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayValueInitialization}
	 * labeled alternative in {@link UISCParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterArrayValueInitialization(UISCParser.ArrayValueInitializationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayValueInitialization}
	 * labeled alternative in {@link UISCParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitArrayValueInitialization(UISCParser.ArrayValueInitializationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayStringInitialization}
	 * labeled alternative in {@link UISCParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterArrayStringInitialization(UISCParser.ArrayStringInitializationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayStringInitialization}
	 * labeled alternative in {@link UISCParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitArrayStringInitialization(UISCParser.ArrayStringInitializationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayAssignmentInitialization}
	 * labeled alternative in {@link UISCParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterArrayAssignmentInitialization(UISCParser.ArrayAssignmentInitializationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayAssignmentInitialization}
	 * labeled alternative in {@link UISCParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitArrayAssignmentInitialization(UISCParser.ArrayAssignmentInitializationContext ctx);
	/**
	 * Enter a parse tree produced by {@link UISCParser#structDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterStructDeclaration(UISCParser.StructDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link UISCParser#structDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitStructDeclaration(UISCParser.StructDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link UISCParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(UISCParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link UISCParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(UISCParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link UISCParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(UISCParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link UISCParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(UISCParser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link UISCParser#structType}.
	 * @param ctx the parse tree
	 */
	void enterStructType(UISCParser.StructTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link UISCParser#structType}.
	 * @param ctx the parse tree
	 */
	void exitStructType(UISCParser.StructTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link UISCParser#inferredType}.
	 * @param ctx the parse tree
	 */
	void enterInferredType(UISCParser.InferredTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link UISCParser#inferredType}.
	 * @param ctx the parse tree
	 */
	void exitInferredType(UISCParser.InferredTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link UISCParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(UISCParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link UISCParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(UISCParser.BooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link UISCParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterArrayInitializer(UISCParser.ArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link UISCParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitArrayInitializer(UISCParser.ArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link UISCParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(UISCParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link UISCParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(UISCParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link UISCParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameters(UISCParser.FormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link UISCParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameters(UISCParser.FormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link UISCParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(UISCParser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link UISCParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(UISCParser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link UISCParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(UISCParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link UISCParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(UISCParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blockStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(UISCParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(UISCParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varDeclarationStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclarationStatement(UISCParser.VarDeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varDeclarationStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclarationStatement(UISCParser.VarDeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code structDeclarationStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStructDeclarationStatement(UISCParser.StructDeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code structDeclarationStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStructDeclarationStatement(UISCParser.StructDeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(UISCParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(UISCParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code uforiStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterUforiStatement(UISCParser.UforiStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code uforiStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitUforiStatement(UISCParser.UforiStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code uforeachStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterUforeachStatement(UISCParser.UforeachStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code uforeachStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitUforeachStatement(UISCParser.UforeachStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(UISCParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(UISCParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(UISCParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(UISCParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(UISCParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(UISCParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignmentStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStatement(UISCParser.AssignmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignmentStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStatement(UISCParser.AssignmentStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code opAndAssignmentStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterOpAndAssignmentStatement(UISCParser.OpAndAssignmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code opAndAssignmentStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitOpAndAssignmentStatement(UISCParser.OpAndAssignmentStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tryCatchStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterTryCatchStatement(UISCParser.TryCatchStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tryCatchStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitTryCatchStatement(UISCParser.TryCatchStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCallStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallStatement(UISCParser.FunctionCallStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCallStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallStatement(UISCParser.FunctionCallStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assemblyStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAssemblyStatement(UISCParser.AssemblyStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assemblyStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAssemblyStatement(UISCParser.AssemblyStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assertionStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAssertionStatement(UISCParser.AssertionStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assertionStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAssertionStatement(UISCParser.AssertionStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exceptionStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExceptionStatement(UISCParser.ExceptionStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exceptionStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExceptionStatement(UISCParser.ExceptionStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code includeStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIncludeStatement(UISCParser.IncludeStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code includeStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIncludeStatement(UISCParser.IncludeStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code flagStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterFlagStatement(UISCParser.FlagStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code flagStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitFlagStatement(UISCParser.FlagStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code flagDataStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterFlagDataStatement(UISCParser.FlagDataStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code flagDataStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitFlagDataStatement(UISCParser.FlagDataStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code breakStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(UISCParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code breakStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(UISCParser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code continueStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(UISCParser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code continueStatement}
	 * labeled alternative in {@link UISCParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(UISCParser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UISCParser#elseifStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseifStatement(UISCParser.ElseifStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UISCParser#elseifStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseifStatement(UISCParser.ElseifStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UISCParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseStatement(UISCParser.ElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UISCParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseStatement(UISCParser.ElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UISCParser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryStatement(UISCParser.TryStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UISCParser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryStatement(UISCParser.TryStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UISCParser#catchStatement}.
	 * @param ctx the parse tree
	 */
	void enterCatchStatement(UISCParser.CatchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UISCParser#catchStatement}.
	 * @param ctx the parse tree
	 */
	void exitCatchStatement(UISCParser.CatchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UISCParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(UISCParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link UISCParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(UISCParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link UISCParser#assembly}.
	 * @param ctx the parse tree
	 */
	void enterAssembly(UISCParser.AssemblyContext ctx);
	/**
	 * Exit a parse tree produced by {@link UISCParser#assembly}.
	 * @param ctx the parse tree
	 */
	void exitAssembly(UISCParser.AssemblyContext ctx);
	/**
	 * Enter a parse tree produced by {@link UISCParser#assertion}.
	 * @param ctx the parse tree
	 */
	void enterAssertion(UISCParser.AssertionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UISCParser#assertion}.
	 * @param ctx the parse tree
	 */
	void exitAssertion(UISCParser.AssertionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UISCParser#exception}.
	 * @param ctx the parse tree
	 */
	void enterException(UISCParser.ExceptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UISCParser#exception}.
	 * @param ctx the parse tree
	 */
	void exitException(UISCParser.ExceptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UISCParser#include}.
	 * @param ctx the parse tree
	 */
	void enterInclude(UISCParser.IncludeContext ctx);
	/**
	 * Exit a parse tree produced by {@link UISCParser#include}.
	 * @param ctx the parse tree
	 */
	void exitInclude(UISCParser.IncludeContext ctx);
	/**
	 * Enter a parse tree produced by {@link UISCParser#flag}.
	 * @param ctx the parse tree
	 */
	void enterFlag(UISCParser.FlagContext ctx);
	/**
	 * Exit a parse tree produced by {@link UISCParser#flag}.
	 * @param ctx the parse tree
	 */
	void exitFlag(UISCParser.FlagContext ctx);
	/**
	 * Enter a parse tree produced by {@link UISCParser#flagData}.
	 * @param ctx the parse tree
	 */
	void enterFlagData(UISCParser.FlagDataContext ctx);
	/**
	 * Exit a parse tree produced by {@link UISCParser#flagData}.
	 * @param ctx the parse tree
	 */
	void exitFlagData(UISCParser.FlagDataContext ctx);
	/**
	 * Enter a parse tree produced by {@link UISCParser#structField}.
	 * @param ctx the parse tree
	 */
	void enterStructField(UISCParser.StructFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link UISCParser#structField}.
	 * @param ctx the parse tree
	 */
	void exitStructField(UISCParser.StructFieldContext ctx);
	/**
	 * Enter a parse tree produced by the {@code postfixOpExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixOpExpression(UISCParser.PostfixOpExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code postfixOpExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixOpExpression(UISCParser.PostfixOpExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code moduloExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterModuloExpression(UISCParser.ModuloExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code moduloExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitModuloExpression(UISCParser.ModuloExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multDivExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultDivExpression(UISCParser.MultDivExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multDivExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultDivExpression(UISCParser.MultDivExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(UISCParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(UISCParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code prefixOpExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPrefixOpExpression(UISCParser.PrefixOpExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prefixOpExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPrefixOpExpression(UISCParser.PrefixOpExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanLiteralExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteralExpression(UISCParser.BooleanLiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanLiteralExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteralExpression(UISCParser.BooleanLiteralExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparisonExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpression(UISCParser.ComparisonExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparisonExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpression(UISCParser.ComparisonExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenExpression(UISCParser.ParenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenExpression(UISCParser.ParenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberLiteralExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumberLiteralExpression(UISCParser.NumberLiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberLiteralExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumberLiteralExpression(UISCParser.NumberLiteralExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valueAtVariableExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterValueAtVariableExpression(UISCParser.ValueAtVariableExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valueAtVariableExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitValueAtVariableExpression(UISCParser.ValueAtVariableExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code castExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCastExpression(UISCParser.CastExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code castExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCastExpression(UISCParser.CastExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nativeCallExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNativeCallExpression(UISCParser.NativeCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nativeCallExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNativeCallExpression(UISCParser.NativeCallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sizeOfExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSizeOfExpression(UISCParser.SizeOfExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sizeOfExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSizeOfExpression(UISCParser.SizeOfExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpression(UISCParser.FunctionCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpression(UISCParser.FunctionCallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bitwiseExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseExpression(UISCParser.BitwiseExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bitwiseExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseExpression(UISCParser.BitwiseExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negateExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNegateExpression(UISCParser.NegateExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negateExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNegateExpression(UISCParser.NegateExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addressOfVariableExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddressOfVariableExpression(UISCParser.AddressOfVariableExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addressOfVariableExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddressOfVariableExpression(UISCParser.AddressOfVariableExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lengthOfExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLengthOfExpression(UISCParser.LengthOfExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lengthOfExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLengthOfExpression(UISCParser.LengthOfExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code structFieldReferenceExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStructFieldReferenceExpression(UISCParser.StructFieldReferenceExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code structFieldReferenceExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStructFieldReferenceExpression(UISCParser.StructFieldReferenceExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringLiteralExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteralExpression(UISCParser.StringLiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringLiteralExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteralExpression(UISCParser.StringLiteralExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayAccessExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccessExpression(UISCParser.ArrayAccessExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayAccessExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccessExpression(UISCParser.ArrayAccessExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variableReferenceExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVariableReferenceExpression(UISCParser.VariableReferenceExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variableReferenceExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVariableReferenceExpression(UISCParser.VariableReferenceExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSubExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddSubExpression(UISCParser.AddSubExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSubExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddSubExpression(UISCParser.AddSubExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andOrXorExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAndOrXorExpression(UISCParser.AndOrXorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andOrXorExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAndOrXorExpression(UISCParser.AndOrXorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalityExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(UISCParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalityExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(UISCParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code charLiteralExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCharLiteralExpression(UISCParser.CharLiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code charLiteralExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCharLiteralExpression(UISCParser.CharLiteralExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ternaryExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTernaryExpression(UISCParser.TernaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ternaryExpression}
	 * labeled alternative in {@link UISCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTernaryExpression(UISCParser.TernaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UISCParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(UISCParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link UISCParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(UISCParser.ExprListContext ctx);
}