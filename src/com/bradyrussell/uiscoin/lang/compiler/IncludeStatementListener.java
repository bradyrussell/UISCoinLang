/* (C) Brady Russell 2021 */
package com.bradyrussell.uiscoin.lang.compiler;


import java.util.List;
import java.util.Map;

import com.bradyrussell.uiscoin.BytesUtil;
import com.bradyrussell.uiscoin.lang.compiler.filesystem.CompilerFileSystem;
import com.bradyrussell.uiscoin.lang.generated.UISCBaseListener;
import com.bradyrussell.uiscoin.lang.generated.UISCParser;
import com.bradyrussell.uiscoin.lang.syntaxhiglighting.SyntaxHighlight;
import com.bradyrussell.uiscoin.lang.syntaxhiglighting.SyntaxHighlighterBase;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStreamRewriter;

public class IncludeStatementListener extends UISCBaseListener {
    private final TokenStreamRewriter rewriter;
    private final CompilerFileSystem fileSystem;

    public IncludeStatementListener(CommonTokenStream tokens, CompilerFileSystem fileSystem) {
        this.rewriter = new TokenStreamRewriter(tokens);
        this.fileSystem = fileSystem;
    }

    @Override
    public void enterIncludeStatement(UISCParser.IncludeStatementContext ctx) {
        if (fileSystem == null) return;
        if (ctx.include() != null && ctx.include().STRING() != null) {
            String pathQuoted = ctx.include().STRING().getText();
            String path = pathQuoted.substring(1, pathQuoted.length() - 1);
            if (fileSystem.exists(path) && fileSystem.isFile(path)) {
                if (path.toLowerCase().endsWith(".uisc")) {
                    rewriter.replace(ctx.start, ctx.stop, "/* Begin Included File: "+path+" */\n"+fileSystem.getFileAsString(path)+"\n/* End Included File: "+path+" */\n");
                }
            }
        }
    }

    @Override
    public void exitIncludeStatement(UISCParser.IncludeStatementContext ctx) {
        super.exitIncludeStatement(ctx);
    }

    public String getText() {
        return rewriter.getText();
    }
}