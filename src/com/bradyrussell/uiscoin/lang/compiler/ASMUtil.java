/* (C) Brady Russell 2021 */
package com.bradyrussell.uiscoin.lang.compiler;

import com.bradyrussell.uiscoin.BytesUtil;
import com.bradyrussell.uiscoin.lang.compiler.filesystem.CompilerFileSystem;
import com.bradyrussell.uiscoin.lang.compiler.filesystem.StandardCompilerFileSystem;
import com.bradyrussell.uiscoin.lang.compiler.type.PrimitiveType;
import com.bradyrussell.uiscoin.lang.generated.UISCLexer;
import com.bradyrussell.uiscoin.lang.generated.UISCParser;
import com.bradyrussell.uiscoin.lang.syntaxhiglighting.SyntaxHighlightGenerator;
import com.bradyrussell.uiscoin.lang.syntaxhiglighting.SyntaxHighlighterHtml;
import com.bradyrussell.uiscoin.script.ScriptParser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class ASMUtil {
    public static boolean bNoComments = true;
    public static CompilerFileSystem defaultFileSystem = null;

    public static String generateComment(String Comment){
        return bNoComments ? "" : "\n/* "+Comment+" */\n";
    }

    public static String generateLoadAddress(int Address) {
        return ASMUtil.generateComment("Load Value from "+Address)+ " push ["+Address+"] pick ";
    }

    public static String generateStoreAddress(int Address) {
        return ASMUtil.generateComment("Store Value to "+Address)+" push ["+Address+"] put ";
    }

    public static String generatePushASMString(String ASMString) {
        return ASMUtil.generateComment("Bytecode for: "+ASMString)+" push { "+ASMString+" } ";
    }

    public static String generateExecuteZippedBytecode(byte[] ZippedByteCode) {
        if(ZippedByteCode.length == 0) throw new UnsupportedOperationException("ZippedByteCode is empty!");
        return " depth push 0x"+ BytesUtil.bytesToHex(ZippedByteCode)+" unzip call verify"; // not tested
    }

    public static String generateExecuteZippedASM(String ASM) {
        return generateExecuteZippedBytecode(BytesUtil.zipBytes(ScriptParser.CompileScriptTokensToBytecode(ScriptParser.GetTokensFromString(ASM,true))));
    }

    // returns asm to cast one type to another, or null if conversion is not allowed
    public static String generateCastAssembly(PrimitiveType From, PrimitiveType To) {
        if (From.equals(To)) return " ";

        StringBuilder asm = new StringBuilder();

        if(PrimitiveType.Void.equals(To) || PrimitiveType.Void.equals(From)) {
            System.out.println("Warning: Casting value from "+From+" to "+To+" might violate type safety!");
            return " ";
        }

        if(From.isPointer()) {
            System.out.println("Warning: Casting value from "+From+" to "+To+" might violate type safety!");
            From = PrimitiveType.Int32;
        }

        if(To.isPointer()) {
            System.out.println("Warning: Casting value from "+From+" to "+To+" might violate type safety!");
            To = PrimitiveType.Int32;
        }

        if (From.equals(PrimitiveType.Byte)) {
            if (To.getSize() > 1) { // int32 is the intermediate type
                asm.append("convert8to32 ");
                From = PrimitiveType.Int32;
            }
        }

        if (From.equals(PrimitiveType.Int64)) {
            // int32 is the intermediate type
            asm.append("convert64to32 ");
            From = PrimitiveType.Int32;
        }

        if (From.equals(PrimitiveType.Float)) {
            // int32 is the intermediate type
            asm.append("convertfloatto32 ");
            From = PrimitiveType.Int32;
        }

        if (From.equals(PrimitiveType.Int32)) {
            switch (To) {
                case Byte -> {
                    asm.append("convert32to8 ");
                    return asm.toString();
                }
                case Int32 -> {
                    return asm.toString();
                }
                case Int64 -> {
                    asm.append("convert32to64 ");
                    return asm.toString();
                }
                case Float -> {
                    asm.append("convert32tofloat ");
                    return asm.toString();
                }
            }
        }

        System.out.println("Cannot cast from "+From+" to "+To+"!");
        return null;
    }

    public static String generatePushNumberLiteralCast(String NumberLiteralString, PrimitiveType CastToType){
        PrimitiveType typeOfInteger = PrimitiveType.deduceTypeOfNumber(NumberLiteralString);
        if(typeOfInteger == null) throw new UnsupportedOperationException("Could not deduce type of number: "+NumberLiteralString);
        return " push " + (PrimitiveType.Byte.equals(typeOfInteger) ? "[":"") + NumberLiteralString + (PrimitiveType.Byte.equals(typeOfInteger) ? "] ":" ")+(CastToType == null ? "":generateCastAssembly(typeOfInteger, CastToType));
    }

    public static String generatePushNumberLiteralCast(long LiteralInteger, PrimitiveType CastToType){
        String NumberLiteralString = Long.toString(LiteralInteger);
        PrimitiveType typeOfInteger = PrimitiveType.deduceTypeOfNumber(NumberLiteralString);
        if(typeOfInteger == null) throw new UnsupportedOperationException("Could not deduce type of number: "+NumberLiteralString);
        return " push " + (PrimitiveType.Byte.equals(typeOfInteger) ? "[":"") + NumberLiteralString + (PrimitiveType.Byte.equals(typeOfInteger) ? "] ":" ")+(CastToType == null ? "":generateCastAssembly(typeOfInteger, CastToType));
    }

    public static String performBasicOptimizations(String ASMString){
        return ASMString
                .replace("push [1]", "true")
                .replace("push [0]", "false")
                .replace("true gotoif", "goto")
                .replace("convert32to8 convert8to32","")
                .replace("convert32to64 convert64to32","");
    }

    public static String resolveIncludes(String HLL, CompilerFileSystem fileSystem) {
        return resolveIncludes(HLL, fileSystem, 32);
    }

    public static String resolveIncludes(String HLL, CompilerFileSystem fileSystem, int maximumDepth) {
        String resolved = HLL;
        for (int i = 0; i < maximumDepth; i++) {
            String nextResolved = resolveIncludesStep(resolved, fileSystem);
            if(nextResolved.equals(resolved)) break;
            resolved = nextResolved;
        }
        return resolved;
    }

    private static String resolveIncludesStep(String HLL, CompilerFileSystem fileSystem) {
        ASMUtil.bNoComments = true;

        if(!HLL.endsWith("\n")) HLL = HLL+"\n";

        @SuppressWarnings("deprecation") UISCLexer lexer = new UISCLexer(new ANTLRInputStream(HLL));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        UISCParser parser = new UISCParser(tokens);
        ParseTree tree = parser.file();

        ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
        IncludeStatementListener includeStatementListener = new IncludeStatementListener(tokens, fileSystem);
        parseTreeWalker.walk(includeStatementListener, tree);
        return includeStatementListener.getText();
    }

    public static String compileHLLToASM(String HLL) {
        return compileHLLToASM(HLL, defaultFileSystem);
    }

    public static String compileHLLToASM(String HLL, CompilerFileSystem fileSystem) {
        //ASMUtil.bNoComments = true;

        String resolvedHLL = ASMUtil.resolveIncludes(HLL, fileSystem);

        System.out.println("Pre-compile HLL:\n"+resolvedHLL);

        @SuppressWarnings("deprecation") UISCLexer lexer = new UISCLexer(new ANTLRInputStream(resolvedHLL));
        UISCParser parser = new UISCParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.file();

        ASMGenerationVisitor asmGenerationVisitor = new ASMGenerationVisitor(fileSystem);
        String asm = asmGenerationVisitor.visit(tree);

        String mainFunctionAsm = asmGenerationVisitor.getMainFunctionAsm();
        return asmGenerationVisitor.Global.getRecursiveAllocation()+ "\n" + asm + " " + (mainFunctionAsm == null ? "" : mainFunctionAsm);
    }

    public static String compileHLLToSyntaxMarkup(String HLL) {
        ASMUtil.bNoComments = true;

        if(!HLL.endsWith("\n")) HLL = HLL+"\n";

        @SuppressWarnings("deprecation") UISCLexer lexer = new UISCLexer(new ANTLRInputStream(HLL));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        UISCParser parser = new UISCParser(tokens);
        ParseTree tree = parser.file();

        ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
        SyntaxHighlightGenerator syntaxHighlighter = new SyntaxHighlightGenerator(tokens, new SyntaxHighlighterHtml());
        parseTreeWalker.walk(syntaxHighlighter, tree);
        return syntaxHighlighter.getText();
    }

    public static String generateLoadArrayElement(int StackElementAddress, String ArrayIndexExpressionCastedToIntASM, int SizeOfElement){
        return  ASMUtil.generatePushNumberLiteralCast(StackElementAddress, PrimitiveType.Int32)+" "+ // push stack element
                ArrayIndexExpressionCastedToIntASM +// push array index auto casted to int
                (SizeOfElement == 1 ? "" : (ASMUtil.generatePushNumberLiteralCast(SizeOfElement,PrimitiveType.Int32)+ // multiply by sizeof to get beginIndex, unless SizeOf is 1
                        " multiply"))+
                ASMUtil.generatePushNumberLiteralCast(SizeOfElement,PrimitiveType.Int32)+
                " get ";  // push sizeof
    }

    // expects the element to store to be on  top of the stack properly casted
    public static String generateStoreArrayElement(int StackElementAddress, String ArrayIndexExpressionCastedToIntASM, int SizeOfElement){
        return /*visit(ctx.rhs) + (bShouldWiden ? " " + generateCastAssembly(rhsType, symbol.type) : " ") +*/
                ASMUtil.generatePushNumberLiteralCast(StackElementAddress, PrimitiveType.Int32)+" "+ // push stack element
                ArrayIndexExpressionCastedToIntASM +// push array index auto casted to int
                (SizeOfElement == 1 ? "" : (ASMUtil.generatePushNumberLiteralCast(SizeOfElement,PrimitiveType.Int32)+ // multiply by sizeof to get beginIndex, unless SizeOf is 1
                        " multiply"))+
                ASMUtil.generatePushNumberLiteralCast(SizeOfElement,PrimitiveType.Int32)+
                " set ";  // push sizeof
    }
}
