/* (C) Brady Russell 2021 */
package com.bradyrussell.uiscoin.lang.compiler;

import com.bradyrussell.uiscoin.lang.generated.UISCBaseVisitor;
import com.bradyrussell.uiscoin.lang.generated.UISCParser;

public class ASMGenAllPathsReturnVisitor extends UISCBaseVisitor<Boolean> {
    @Override
    protected Boolean defaultResult() {
        return false;
    }

    @Override
    protected Boolean aggregateResult(Boolean aggregate, Boolean nextResult) {
        if(aggregate == null) return null;
        if(nextResult == null) return null;
        return aggregate || nextResult;
    }

    @Override
    public Boolean visitReturnStatement(UISCParser.ReturnStatementContext ctx) {
        return true;
    }

    @Override
    public Boolean visitException(UISCParser.ExceptionContext ctx) {
        return true;
    }

    // any control flow splitting rules need to be overridden

    @Override
    public Boolean visitIfStatement(UISCParser.IfStatementContext ctx) {
        boolean allElseIfsReturn = true;

        for (UISCParser.ElseifStatementContext elseifStatementContext : ctx.elseifStatement()) {
            allElseIfsReturn &= visit(elseifStatementContext);
        }

        if(ctx.elseStatement() == null) return false;

        return visit(ctx.ifbody) && visit(ctx.elseStatement()) && allElseIfsReturn;
    }
}
