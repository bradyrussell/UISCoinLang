/* (C) Brady Russell 2021 */
package com.bradyrussell.uiscoin.lang.syntaxhiglighting;


import java.util.List;
import java.util.Map;

import com.bradyrussell.uiscoin.lang.generated.UISCBaseListener;
import com.bradyrussell.uiscoin.lang.generated.UISCParser;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.tree.TerminalNode;

public class SyntaxHighlightGenerator extends UISCBaseListener {
    private final CommonTokenStream tokens;
    private final TokenStreamRewriter rewriter;

    private final SyntaxHighlighterBase syntaxHighlighter;

    public SyntaxHighlightGenerator(CommonTokenStream tokens, SyntaxHighlighterBase syntaxHighlighter) {
        this.tokens = tokens;
        this.rewriter = new TokenStreamRewriter(tokens);
        this.syntaxHighlighter = syntaxHighlighter;
    }

    @Override
    public void enterPrimitiveType(UISCParser.PrimitiveTypeContext ctx) {
        SyntaxHighlight type = SyntaxHighlight.PrimitiveType;
        rewriter.insertBefore(ctx.start, syntaxHighlighter.getOpenTag(type));
        rewriter.insertAfter(ctx.stop, syntaxHighlighter.getCloseTag(type));
    }

    @Override
    public void enterStructType(UISCParser.StructTypeContext ctx) {
        SyntaxHighlight type = SyntaxHighlight.StructType;
        rewriter.insertBefore(ctx.start, syntaxHighlighter.getOpenTag(type));
        rewriter.insertAfter(ctx.stop, syntaxHighlighter.getCloseTag(type));
    }

    @Override
    public void enterVarInitialization(UISCParser.VarInitializationContext ctx) {
        if(ctx.constant != null) {
            rewriter.insertBefore(ctx.constant, syntaxHighlighter.getOpenTag(SyntaxHighlight.Const));
            rewriter.insertAfter(ctx.constant, syntaxHighlighter.getCloseTag(SyntaxHighlight.Const));
        }
        if(ctx.ID().getSymbol() != null) {
            rewriter.insertBefore(ctx.ID().getSymbol(), syntaxHighlighter.getOpenTag(SyntaxHighlight.Variable));
            rewriter.insertAfter(ctx.ID().getSymbol(), syntaxHighlighter.getCloseTag(SyntaxHighlight.Variable));
        }
    }

    @Override
    public void enterStringLiteralExpression(UISCParser.StringLiteralExpressionContext ctx) {
        SyntaxHighlight type = SyntaxHighlight.StringLiteral;
        rewriter.insertBefore(ctx.start, syntaxHighlighter.getOpenTag(type));
        rewriter.insertAfter(ctx.stop, syntaxHighlighter.getCloseTag(type));
    }

    @Override
    public void enterArrayValueInitialization(UISCParser.ArrayValueInitializationContext ctx) {
        if(ctx.ID().getSymbol() != null) {
            rewriter.insertBefore(ctx.ID().getSymbol(), syntaxHighlighter.getOpenTag(SyntaxHighlight.Variable));
            rewriter.insertAfter(ctx.ID().getSymbol(), syntaxHighlighter.getCloseTag(SyntaxHighlight.Variable));
        }
    }

    @Override
    public void enterArrayAccessExpression(UISCParser.ArrayAccessExpressionContext ctx) {
        if(ctx.ID().getSymbol() != null) {
            rewriter.insertBefore(ctx.ID().getSymbol(), syntaxHighlighter.getOpenTag(SyntaxHighlight.Variable));
            rewriter.insertAfter(ctx.ID().getSymbol(), syntaxHighlighter.getCloseTag(SyntaxHighlight.Variable));
        }
    }

    @Override
    public void enterArrayStringInitialization(UISCParser.ArrayStringInitializationContext ctx) {
        if(ctx.STRING().getSymbol() != null) {
            rewriter.insertBefore(ctx.STRING().getSymbol(), syntaxHighlighter.getOpenTag(SyntaxHighlight.StringLiteral));
            rewriter.insertAfter(ctx.STRING().getSymbol(), syntaxHighlighter.getCloseTag(SyntaxHighlight.StringLiteral));
        }
        if(ctx.ID().getSymbol() != null) {
            rewriter.insertBefore(ctx.ID().getSymbol(), syntaxHighlighter.getOpenTag(SyntaxHighlight.Variable));
            rewriter.insertAfter(ctx.ID().getSymbol(), syntaxHighlighter.getCloseTag(SyntaxHighlight.Variable));
        }
    }

    @Override
    public void enterAssignmentStatement(UISCParser.AssignmentStatementContext ctx) {
        if(ctx.lhs != null) {
            rewriter.insertBefore(ctx.lhs, syntaxHighlighter.getOpenTag(SyntaxHighlight.Variable));
            rewriter.insertAfter(ctx.lhs, syntaxHighlighter.getCloseTag(SyntaxHighlight.Variable));
        }
    }

    @Override
    public void enterOpAndAssignmentStatement(UISCParser.OpAndAssignmentStatementContext ctx) {
        if(ctx.lhs != null) {
            rewriter.insertBefore(ctx.lhs, syntaxHighlighter.getOpenTag(SyntaxHighlight.Variable));
            rewriter.insertAfter(ctx.lhs, syntaxHighlighter.getCloseTag(SyntaxHighlight.Variable));
        }
    }

    @Override
    public void enterStructField(UISCParser.StructFieldContext ctx) {
        for (TerminalNode terminalNode : ctx.ID()) {
            if(terminalNode.getSymbol() != null) {
                rewriter.insertBefore(terminalNode.getSymbol(), syntaxHighlighter.getOpenTag(SyntaxHighlight.Variable));
                rewriter.insertAfter(terminalNode.getSymbol(), syntaxHighlighter.getCloseTag(SyntaxHighlight.Variable));
            }
        }
    }

    @Override
    public void enterAssembly(UISCParser.AssemblyContext ctx) {
        rewriter.insertBefore(ctx.start, syntaxHighlighter.getOpenTag(SyntaxHighlight.Keyword));
        rewriter.insertAfter(ctx.start, syntaxHighlighter.getCloseTag(SyntaxHighlight.Keyword));
        if(ctx.STRING().getSymbol() != null) {
            rewriter.insertBefore(ctx.STRING().getSymbol(), syntaxHighlighter.getOpenTag(SyntaxHighlight.StringLiteral));
            rewriter.insertAfter(ctx.STRING().getSymbol(), syntaxHighlighter.getCloseTag(SyntaxHighlight.StringLiteral));
        }
    }

    @Override
    public void enterFlagData(UISCParser.FlagDataContext ctx) {
        if(ctx.STRING().getSymbol() != null) {
            rewriter.insertBefore(ctx.STRING().getSymbol(), syntaxHighlighter.getOpenTag(SyntaxHighlight.StringLiteral));
            rewriter.insertAfter(ctx.STRING().getSymbol(), syntaxHighlighter.getCloseTag(SyntaxHighlight.StringLiteral));
        }
    }

    @Override
    public void enterCharLiteralExpression(UISCParser.CharLiteralExpressionContext ctx) {
        SyntaxHighlight type = SyntaxHighlight.StringLiteral;
        rewriter.insertBefore(ctx.start, syntaxHighlighter.getOpenTag(type));
        rewriter.insertAfter(ctx.stop, syntaxHighlighter.getCloseTag(type));
    }

    @Override
    public void enterInclude(UISCParser.IncludeContext ctx) {
        if(ctx.STRING().getSymbol() != null) {
            rewriter.insertBefore(ctx.STRING().getSymbol(), syntaxHighlighter.getOpenTag(SyntaxHighlight.StringLiteral));
            rewriter.insertAfter(ctx.STRING().getSymbol(), syntaxHighlighter.getCloseTag(SyntaxHighlight.StringLiteral));
        }
    }

    @Override
    public void enterNativeCallExpression(UISCParser.NativeCallExpressionContext ctx) {
        if(ctx.ID().getSymbol() != null) {
            rewriter.insertBefore(ctx.start, syntaxHighlighter.getOpenTag(SyntaxHighlight.NativeCall));
            rewriter.insertAfter(ctx.ID().getSymbol(), syntaxHighlighter.getCloseTag(SyntaxHighlight.NativeCall));
        }
    }

    @Override
    public void enterNumber(UISCParser.NumberContext ctx) {
        SyntaxHighlight type = SyntaxHighlight.NumberLiteral;
        rewriter.insertBefore(ctx.start, syntaxHighlighter.getOpenTag(type));
        rewriter.insertAfter(ctx.stop, syntaxHighlighter.getCloseTag(type));
    }

    @Override
    public void enterStructDeclaration(UISCParser.StructDeclarationContext ctx) {
        rewriter.insertBefore(ctx.start, syntaxHighlighter.getOpenTag(SyntaxHighlight.Keyword));
        rewriter.insertAfter(ctx.start, syntaxHighlighter.getCloseTag(SyntaxHighlight.Keyword));
        if(ctx.ID().getSymbol() != null) {
            rewriter.insertBefore(ctx.start, syntaxHighlighter.getOpenTag(SyntaxHighlight.StructType));
            rewriter.insertAfter(ctx.ID().getSymbol(), syntaxHighlighter.getCloseTag(SyntaxHighlight.StructType));
        }
    }

    @Override
    public void enterAddressOfVariableExpression(UISCParser.AddressOfVariableExpressionContext ctx) {
        rewriter.insertBefore(ctx.start, syntaxHighlighter.getOpenTag(SyntaxHighlight.AddressOf));
        rewriter.insertAfter(ctx.start, syntaxHighlighter.getCloseTag(SyntaxHighlight.AddressOf));
        if(ctx.ID().getSymbol() != null) {
            rewriter.insertBefore(ctx.ID().getSymbol(), syntaxHighlighter.getOpenTag(SyntaxHighlight.Variable));
            rewriter.insertAfter(ctx.ID().getSymbol(), syntaxHighlighter.getCloseTag(SyntaxHighlight.Variable));
        }
    }

    @Override
    public void enterValueAtVariableExpression(UISCParser.ValueAtVariableExpressionContext ctx) {
        rewriter.insertBefore(ctx.start, syntaxHighlighter.getOpenTag(SyntaxHighlight.ValueAt));
        rewriter.insertAfter(ctx.start, syntaxHighlighter.getCloseTag(SyntaxHighlight.ValueAt));
    }

    @Override
    public void enterReturnStatement(UISCParser.ReturnStatementContext ctx) {
        rewriter.insertBefore(ctx.start, syntaxHighlighter.getOpenTag(SyntaxHighlight.Keyword));
        rewriter.insertAfter(ctx.start, syntaxHighlighter.getCloseTag(SyntaxHighlight.Keyword));
    }

    @Override
    public void enterUforiStatement(UISCParser.UforiStatementContext ctx) {
        rewriter.insertBefore(ctx.start, syntaxHighlighter.getOpenTag(SyntaxHighlight.Keyword));
        rewriter.insertAfter(ctx.start, syntaxHighlighter.getCloseTag(SyntaxHighlight.Keyword));
        for (TerminalNode terminalNode : ctx.INT()) {
            if(terminalNode.getSymbol() != null) {
                rewriter.insertBefore(terminalNode.getSymbol(), syntaxHighlighter.getOpenTag(SyntaxHighlight.NumberLiteral));
                rewriter.insertAfter(terminalNode.getSymbol(), syntaxHighlighter.getCloseTag(SyntaxHighlight.NumberLiteral));
            }
        }

        if(ctx.as != null) {
            rewriter.insertBefore(ctx.as, syntaxHighlighter.getOpenTag(SyntaxHighlight.Keyword));
            rewriter.insertAfter(ctx.as, syntaxHighlighter.getCloseTag(SyntaxHighlight.Keyword));
        }

        if(ctx.ID().getSymbol() != null) {
            rewriter.insertBefore(ctx.ID().getSymbol(), syntaxHighlighter.getOpenTag(SyntaxHighlight.Variable));
            rewriter.insertAfter(ctx.ID().getSymbol(), syntaxHighlighter.getCloseTag(SyntaxHighlight.Variable));
        }
    }

    @Override
    public void enterUforeachStatement(UISCParser.UforeachStatementContext ctx) {
        rewriter.insertBefore(ctx.start, syntaxHighlighter.getOpenTag(SyntaxHighlight.Keyword));
        rewriter.insertAfter(ctx.start, syntaxHighlighter.getCloseTag(SyntaxHighlight.Keyword));
        if(ctx.as != null) {
            rewriter.insertBefore(ctx.as, syntaxHighlighter.getOpenTag(SyntaxHighlight.Keyword));
            rewriter.insertAfter(ctx.as, syntaxHighlighter.getCloseTag(SyntaxHighlight.Keyword));
        }
    }

    @Override
    public void enterForStatement(UISCParser.ForStatementContext ctx) {
        rewriter.insertBefore(ctx.start, syntaxHighlighter.getOpenTag(SyntaxHighlight.Keyword));
        rewriter.insertAfter(ctx.start, syntaxHighlighter.getCloseTag(SyntaxHighlight.Keyword));
    }

    @Override
    public void enterArrayAssignmentInitialization(UISCParser.ArrayAssignmentInitializationContext ctx) {
        if(ctx.ID().getSymbol() != null) {
            rewriter.insertBefore(ctx.ID().getSymbol(), syntaxHighlighter.getOpenTag(SyntaxHighlight.Variable));
            rewriter.insertAfter(ctx.ID().getSymbol(), syntaxHighlighter.getCloseTag(SyntaxHighlight.Variable));
        }
        if(ctx.INT().getSymbol() != null) {
            rewriter.insertBefore(ctx.INT().getSymbol(), syntaxHighlighter.getOpenTag(SyntaxHighlight.NumberLiteral));
            rewriter.insertAfter(ctx.INT().getSymbol(), syntaxHighlighter.getCloseTag(SyntaxHighlight.NumberLiteral));
        }
    }

    @Override
    public void enterFormalParameter(UISCParser.FormalParameterContext ctx) {

        if(ctx.ID().getSymbol() != null) {
            rewriter.insertBefore(ctx.ID().getSymbol(), syntaxHighlighter.getOpenTag(SyntaxHighlight.Variable));
            rewriter.insertAfter(ctx.ID().getSymbol(), syntaxHighlighter.getCloseTag(SyntaxHighlight.Variable));
        }
    }

    @Override
    public void enterFunctionCallExpression(UISCParser.FunctionCallExpressionContext ctx) {
        if(ctx.ID().getSymbol() != null) {
            rewriter.insertBefore(ctx.ID().getSymbol(), syntaxHighlighter.getOpenTag(SyntaxHighlight.Function));
            rewriter.insertAfter(ctx.ID().getSymbol(), syntaxHighlighter.getCloseTag(SyntaxHighlight.Function));
        }
    }

    @Override
    public void enterFunctionDeclaration(UISCParser.FunctionDeclarationContext ctx) {
        if(ctx.ID().getSymbol() != null) {
            rewriter.insertBefore(ctx.ID().getSymbol(), syntaxHighlighter.getOpenTag(SyntaxHighlight.Function));
            rewriter.insertAfter(ctx.ID().getSymbol(), syntaxHighlighter.getCloseTag(SyntaxHighlight.Function));
        }
    }

    @Override
    public void enterVariableReferenceExpression(UISCParser.VariableReferenceExpressionContext ctx) {
        if(ctx.ID().getSymbol() != null) {
            rewriter.insertBefore(ctx.ID().getSymbol(), syntaxHighlighter.getOpenTag(SyntaxHighlight.Variable));
            rewriter.insertAfter(ctx.ID().getSymbol(), syntaxHighlighter.getCloseTag(SyntaxHighlight.Variable));
        }
    }

    public String getText() {
        for (int i = 0; i < tokens.size(); i++) {
            if(tokens.getTokens().get(i).getChannel() == 0) {
                List<Token> tokensToRight = tokens.getHiddenTokensToRight(i, 2);
                if(tokensToRight != null) {
                    rewriter.insertBefore(tokensToRight.get(0), syntaxHighlighter.getOpenTag(SyntaxHighlight.Comment));
                    rewriter.insertAfter(tokensToRight.get(tokensToRight.size()-1), syntaxHighlighter.getCloseTag(SyntaxHighlight.Comment));
                }
            }
        }

        String rewriterText = rewriter.getText();

        for (Map.Entry<String, String> replacement : syntaxHighlighter.getReplacements().entrySet()) {
            rewriterText = rewriterText.replace(replacement.getKey(), replacement.getValue());
        }

        return syntaxHighlighter.getGlobalOpenTag() + rewriterText + syntaxHighlighter.getGlobalCloseTag();
    }
}