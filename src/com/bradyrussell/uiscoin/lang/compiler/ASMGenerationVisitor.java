/* (C) Brady Russell 2021 */
package com.bradyrussell.uiscoin.lang.compiler;

import java.util.*;

import com.bradyrussell.uiscoin.BytesUtil;
import com.bradyrussell.uiscoin.lang.compiler.filesystem.CompilerFileSystem;
import com.bradyrussell.uiscoin.lang.compiler.scope.*;
import com.bradyrussell.uiscoin.lang.compiler.symbol.*;
import com.bradyrussell.uiscoin.lang.compiler.type.*;
import com.bradyrussell.uiscoin.lang.generated.UISCBaseVisitor;
import com.bradyrussell.uiscoin.lang.generated.UISCParser;
import com.bradyrussell.uiscoin.script.ScriptOperator;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

public class ASMGenerationVisitor extends UISCBaseVisitor<String> {
    private String mainFunctionAsm = null;

    public String getMainFunctionAsm() {
        return mainFunctionAsm;
    }

    int LabelIndex = 0;

    public ScopeGlobal Global = new ScopeGlobal("GlobalScope", null);
    public ScopeLocal CurrentLocalScope = null;

    ScopeBase getCurrentScope() {
        return CurrentLocalScope == null ? Global : CurrentLocalScope;
    }

    void PushLocalScope(String ScopeName) {
        if (CurrentLocalScope == null) {
            CurrentLocalScope = new ScopeLocal(ScopeName, Global);
            Global.Children.add(CurrentLocalScope);
        } else {
            ScopeLocal parent = CurrentLocalScope;
            CurrentLocalScope = new ScopeLocal(ScopeName, parent);
            parent.Children.add(CurrentLocalScope);
        }
    }

    ScopeCapture PushLocalScopeCapture(String ScopeName) {
        if (CurrentLocalScope == null) {
            CurrentLocalScope = new ScopeCapture(ScopeName, Global);
            Global.Children.add(CurrentLocalScope);
        } else {
            ScopeLocal parent = CurrentLocalScope;
            CurrentLocalScope = new ScopeCapture(ScopeName, parent);
            parent.Children.add(CurrentLocalScope);
        }
        return (ScopeCapture) CurrentLocalScope;
    }

    void PushFunctionScope(PrimitiveType FunctionType, String FunctionName, List<NameAndType> Parameters) {
        if (CurrentLocalScope == null) {
            CurrentLocalScope = Global.defineFunction(FunctionName, FunctionType, Parameters);
        } else {
            CurrentLocalScope = CurrentLocalScope.defineFunction(FunctionName, FunctionType, Parameters);
        }
    }

    void PopLocalScope() {
        if (CurrentLocalScope.Parent instanceof ScopeLocal) {
            CurrentLocalScope = (ScopeLocal) CurrentLocalScope.Parent;
            return;
        }
        CurrentLocalScope = null;
    }

    private String generateCompilerError(String message, ParserRuleContext ctx) {
        return "/* COMPILER_ERROR@L" + ctx.start.getLine() + "C" + ctx.start.getCharPositionInLine()+"<"+message+"> */";
    }

    private String generateCompilerWarning(String message, ParserRuleContext ctx) {
        return "/* COMPILER_WARNING@L" + ctx.start.getLine() + "C" + ctx.start.getCharPositionInLine()+"<"+message+"> */";
    }

    ////////////////////////
    private final CompilerFileSystem fileSystem;

    public ASMGenerationVisitor(CompilerFileSystem fileSystem) {
        this.fileSystem = fileSystem;

        Global.defineNative("set", PrimitiveType.Void, List.of(
                new NameAndType("location", new PrimitiveStructOrArrayType(PrimitiveType.Int32)),
                new NameAndType("position", new PrimitiveStructOrArrayType(PrimitiveType.Int32)),
                new NameAndType("length", new PrimitiveStructOrArrayType(PrimitiveType.Int32)),
                new NameAndType("value", new PrimitiveStructOrArrayType(PrimitiveType.Int32))
        ));

        Global.defineNative("get", PrimitiveType.ByteArray, List.of(
                new NameAndType("location", new PrimitiveStructOrArrayType(PrimitiveType.Int32)),
                new NameAndType("position", new PrimitiveStructOrArrayType(PrimitiveType.Int32)),
                new NameAndType("length", new PrimitiveStructOrArrayType(PrimitiveType.Int32))
        ));

        Global.defineNative("copy", PrimitiveType.Void, List.of(
                new NameAndType("sourceLocation", new PrimitiveStructOrArrayType(PrimitiveType.VoidPointer)),
                new NameAndType("sourcePosition", new PrimitiveStructOrArrayType(PrimitiveType.Int32)),
                new NameAndType("destinationLocation", new PrimitiveStructOrArrayType(PrimitiveType.VoidPointer)),
                new NameAndType("destinationPosition", new PrimitiveStructOrArrayType(PrimitiveType.Int32)),
                new NameAndType("length", new PrimitiveStructOrArrayType(PrimitiveType.Int32))
        ));

        Global.defineNative("encrypt", PrimitiveType.ByteArray, List.of(
                new NameAndType("key", new PrimitiveStructOrArrayType(PrimitiveType.ByteArray)),
                new NameAndType("data", new PrimitiveStructOrArrayType(PrimitiveType.ByteArray))
        ));

        Global.defineNative("decrypt", PrimitiveType.ByteArray, List.of(
                new NameAndType("key", new PrimitiveStructOrArrayType(PrimitiveType.ByteArray)),
                new NameAndType("data", new PrimitiveStructOrArrayType(PrimitiveType.ByteArray))
        ));

        Global.defineNative("verifySig", PrimitiveType.Void, List.of(
                new NameAndType("signature", new PrimitiveStructOrArrayType(PrimitiveType.ByteArray)),
                new NameAndType("publicKey", new PrimitiveStructOrArrayType(PrimitiveType.ByteArray))
        ));

        Global.defineNative("alloc", PrimitiveType.Void, List.of(
                new NameAndType("location", new PrimitiveStructOrArrayType(PrimitiveType.Int32)),
                new NameAndType("size", new PrimitiveStructOrArrayType(PrimitiveType.Int32))
        ));

        Global.defineNative("zip", PrimitiveType.ByteArray, List.of(
                new NameAndType("data", new PrimitiveStructOrArrayType(PrimitiveType.ByteArray))
        ));

        Global.defineNative("unzip", PrimitiveType.ByteArray, List.of(
                new NameAndType("data", new PrimitiveStructOrArrayType(PrimitiveType.ByteArray))
        ));

        Global.defineNative("sha512", PrimitiveType.ByteArray, List.of(
                new NameAndType("data", new PrimitiveStructOrArrayType(PrimitiveType.ByteArray))
        ));

        Global.defineNative("instruction", PrimitiveType.Int32, List.of());

        Global.defineNative("log", PrimitiveType.Float, List.of(
                new NameAndType("value", new PrimitiveStructOrArrayType(PrimitiveType.Float))
        ));

        Global.defineNative("logn", PrimitiveType.Float, List.of(
                new NameAndType("value", new PrimitiveStructOrArrayType(PrimitiveType.Float)),
                new NameAndType("n", new PrimitiveStructOrArrayType(PrimitiveType.Float))
        ));

        Global.defineNative("isinf", PrimitiveType.Byte, List.of(
                new NameAndType("value", new PrimitiveStructOrArrayType(PrimitiveType.Float))
        ));

        Global.defineNative("isnan", PrimitiveType.Byte, List.of(
                new NameAndType("value", new PrimitiveStructOrArrayType(PrimitiveType.Float))
        ));

        Global.defineNative("isfin", PrimitiveType.Byte, List.of(
                new NameAndType("value", new PrimitiveStructOrArrayType(PrimitiveType.Float))
        ));

        Global.defineNative("pow", PrimitiveType.Float, List.of(
                new NameAndType("value", new PrimitiveStructOrArrayType(PrimitiveType.Float)),
                new NameAndType("power", new PrimitiveStructOrArrayType(PrimitiveType.Float))
        ));

        Global.defineNative("root", PrimitiveType.Float, List.of(
                new NameAndType("value", new PrimitiveStructOrArrayType(PrimitiveType.Float)),
                new NameAndType("root", new PrimitiveStructOrArrayType(PrimitiveType.Float))
        ));

        Global.defineNative("abs", PrimitiveType.Int64, List.of(
                new NameAndType("value", new PrimitiveStructOrArrayType(PrimitiveType.Int64))
        ));

        Global.defineNative("fabs", PrimitiveType.Float, List.of(
                new NameAndType("value", new PrimitiveStructOrArrayType(PrimitiveType.Float))
        ));

        Global.defineNative("sin", PrimitiveType.Float, List.of(
                new NameAndType("value", new PrimitiveStructOrArrayType(PrimitiveType.Float))
        ));

        Global.defineNative("cos", PrimitiveType.Float, List.of(
                new NameAndType("value", new PrimitiveStructOrArrayType(PrimitiveType.Float))
        ));

        Global.defineNative("tan", PrimitiveType.Float, List.of(
                new NameAndType("value", new PrimitiveStructOrArrayType(PrimitiveType.Float))
        ));

        Global.defineNative("asin", PrimitiveType.Float, List.of(
                new NameAndType("value", new PrimitiveStructOrArrayType(PrimitiveType.Float))
        ));

        Global.defineNative("acos", PrimitiveType.Float, List.of(
                new NameAndType("value", new PrimitiveStructOrArrayType(PrimitiveType.Float))
        ));

        Global.defineNative("atan", PrimitiveType.Float, List.of(
                new NameAndType("value", new PrimitiveStructOrArrayType(PrimitiveType.Float))
        ));

        Global.defineNative("floor", PrimitiveType.Float, List.of(
                new NameAndType("value", new PrimitiveStructOrArrayType(PrimitiveType.Float))
        ));

        Global.defineNative("ceil", PrimitiveType.Float, List.of(
                new NameAndType("value", new PrimitiveStructOrArrayType(PrimitiveType.Float))
        ));

        Global.defineNative("round", PrimitiveType.Float, List.of(
                new NameAndType("value", new PrimitiveStructOrArrayType(PrimitiveType.Float))
        ));

        Global.defineNative("len", PrimitiveType.Int32, List.of(
                new NameAndType("value", new PrimitiveStructOrArrayType(PrimitiveType.Void))
        ));

        Global.defineNative("sizeof", PrimitiveType.Int32, List.of(
                new NameAndType("value", new PrimitiveStructOrArrayType(PrimitiveType.Void))
        ));
    }

    private String getNextLabel() {
        return "L" + LabelIndex++;
    }

    //todo Literal calculation visitor? like 2+5+2 would just return 9? or just add to the visitor if both are literals return the calc'd value
    /*
    could make a LiteralCalculatorVisitor<TypedValue> that implements +, -, *, etc
     for only literals returns null on expressions etc then everything here tries to run it before doing its calculations
     that way stuff like 5 * 5 would generate 25 in the asm or true & false
     */

    private static String stripQuotesFromString(String QuotedString) {
        return QuotedString.substring(1, QuotedString.length() - 1);
    }

    private String getCastedBinaryExpression(UISCParser.ExpressionContext LHS, UISCParser.ExpressionContext RHS, String BinaryOperationForIntegers, String BinaryOperationForFloats, ParserRuleContext ctx) {
        PrimitiveType lhsType = LHS.accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));
        PrimitiveType rhsType = RHS.accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));

        if (lhsType == null || rhsType == null) {
            return generateCompilerError("Type null! Cannot determine type: " + lhsType + " and " + rhsType, ctx);
        }

        PrimitiveType outputType = PrimitiveType.getWiderType(lhsType, rhsType);

        if (outputType == null) {
            return generateCompilerError("Type mismatch! Cannot combine types " + lhsType + " and " + rhsType, ctx);
        }

        return visit(LHS) + " " + ASMUtil.generateCastAssembly(lhsType, outputType) + visit(RHS) + " " + ASMUtil.generateCastAssembly(rhsType, outputType) + (outputType.equals(PrimitiveType.Float) ? BinaryOperationForFloats : BinaryOperationForIntegers) + " ";
    }

    @Override
    protected String defaultResult() {
        return "";
    }

    @Override
    protected String aggregateResult(String aggregate, String nextResult) {
        if (aggregate.isEmpty()) return nextResult;
        return aggregate + "\n" + nextResult;
    }

    /**
     * Begin Literals
     */

    @Override
    public String visitNumberLiteralExpression(UISCParser.NumberLiteralExpressionContext ctx) {
        return ASMUtil.generatePushNumberLiteralCast(ctx.number().getText(), null);
    }

    @Override
    public String visitStringLiteralExpression(UISCParser.StringLiteralExpressionContext ctx) {
        return ASMUtil.generateComment("String literal " + ctx.getText()) + "push " + ctx.STRING().getText();
    }

    @Override
    public String visitCharLiteralExpression(UISCParser.CharLiteralExpressionContext ctx) {
        return ASMUtil.generateComment("Char literal " + ctx.getText()) + "push " + ctx.CHAR().getText().replace("'", "\"");
    }

    @Override
    public String visitBooleanLiteral(UISCParser.BooleanLiteralContext ctx) {
        if (ctx.nullliteral != null) {
            return ASMUtil.generateComment("Null literal " + ctx.getText()) + "null";
        }
        if (ctx.trueliteral != null) {
            return ASMUtil.generateComment("True literal " + ctx.getText()) + "true";
        }
        if (ctx.falseliteral != null) {
            return ASMUtil.generateComment("False literal " + ctx.getText()) + "false";
        }
        //return ctx.getText(); // this was more elegant but the above is more resistant to future changes
        return "";
    }

    /** End Literals */

    /**
     * Begin Initialization
     */

    @Override
    public String visitArrayStringInitialization(UISCParser.ArrayStringInitializationContext ctx) {
        PrimitiveType byKeyword = PrimitiveType.getByKeyword(ctx.type().getText());

        if (byKeyword == null || !PrimitiveType.ByteArray.equals(byKeyword.toArray())) {
            return generateCompilerError("Cannot string initialize " + byKeyword + " array! " + ctx.ID().getText(), ctx);
        }

        String strValue = stripQuotesFromString(ctx.STRING().getText());
        int address = getCurrentScope().declareArray(ctx.ID().getText(), byKeyword.toArray(), strValue.length());

        if (address < 0) {
            return generateCompilerError("Symbol was already defined in this scope! " + ctx.ID().getText(), ctx);
        }

        return ASMUtil.generateComment("Array string initialization " + ctx.getText()) + " push \"" + strValue + "\"" + ASMUtil.generateStoreAddress(address)/*" push [" + address + "] put"*/;
    }

    @Override
    public String visitArrayAssignmentInitialization(UISCParser.ArrayAssignmentInitializationContext ctx) {
        if (ctx.type().primitiveType() == null) {

            StructDefinition structDefinition = getCurrentScope().findStructDefinition(ctx.type().structType().getText());

            if (structDefinition == null) {
                return generateCompilerError("Struct type " + ctx.type().structType().getText() + " was not defined in this scope.", ctx);
            }

            int address = getCurrentScope().declareArray(ctx.ID().getText(), null, Integer.parseInt(ctx.INT().getText()));

            if (address < 0) {
                return generateCompilerError("Symbol was already defined in this scope! " + ctx.ID().getText(), ctx);
            }

            if (ctx.expression() != null) {
                return generateCompilerError("Value initializing struct arrays is not supported;", ctx);
                /*PrimitiveType expressionType = ctx.expression().accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));
                if(!symbolType.equals(expressionType)) {
                    System.out.println("Cannot initialize "+symbolType+" array with "+expressionType+"! " + ctx.ID().getText());
                    return "TYPE_MISMATCH_" + ctx.ID().getText();
                }

                return visit(ctx.expression()) +" "+ASMUtil.generateStoreAddress(address);*/
            }

            return ASMUtil.generatePushNumberLiteralCast(Integer.toString(structDefinition.getSize() * Integer.parseInt(ctx.INT().getText())), PrimitiveType.Int32) + " alloc " + ASMUtil.generateStoreAddress(address);//"push ["+address+"] put";
        }

        PrimitiveType symbolType = ctx.type().pointer() == null ? PrimitiveType.getByKeyword(ctx.type().primitiveType().getText()) : PrimitiveType.getByKeyword(ctx.type().primitiveType().getText()).toPointer();

        if (symbolType == null) {
            throw new UnsupportedOperationException("Struct array assignment not yet implemented");
        }

        int address = getCurrentScope().declareArray(ctx.ID().getText(), symbolType, Integer.parseInt(ctx.INT().getText()));

        if (address < 0) {
            return generateCompilerError("Symbol was already defined in this scope! " + ctx.ID().getText(), ctx);
        }

        if (ctx.expression() != null) {
            PrimitiveType expressionType = ctx.expression().accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));
            if (!symbolType.equals(expressionType)) {
                return generateCompilerError("Cannot initialize " + symbolType + " array with " + expressionType + "! " + ctx.ID().getText(), ctx);
            }

            return visit(ctx.expression()) + " " + ASMUtil.generateStoreAddress(address);
        }

        return ASMUtil.generatePushNumberLiteralCast(Integer.toString(symbolType.getSize() * Integer.parseInt(ctx.INT().getText())), PrimitiveType.Int32) + " alloc " + ASMUtil.generateStoreAddress(address);//"push ["+address+"] put";
    }

    @Override
    public String visitVarInitialization(UISCParser.VarInitializationContext ctx) {

        PrimitiveType primitiveType = null;

        if (ctx.type().inferredType() != null) {
            primitiveType = ctx.expression().accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));
        }

        if (ctx.type().primitiveType() != null) {
            primitiveType = ctx.type().pointer() == null ? PrimitiveType.getByKeyword(ctx.type().primitiveType().getText()) : PrimitiveType.getByKeyword(ctx.type().primitiveType().getText()).toPointer();
        }

        if (primitiveType != null) {
            if (ctx.constant == null) {
                int address = getCurrentScope().declareSymbol(ctx.ID().getText(), primitiveType);

                if (address < 0) {
                    System.out.println("Symbol was already defined in this scope! " + ctx.ID().getText());
                    return generateCompilerError("SYMBOL_REDEFINITION_" + ctx.ID().getText(), ctx);
                }

                System.out.println(">>Initialized symbol " + ctx.ID().getText() + " of type " + primitiveType + " with address " + address);

                if (ctx.expression() != null) {
                    PrimitiveType rhsType = ctx.expression().accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));

                    if (rhsType == null)
                        throw new UnsupportedOperationException("Could not determine the type of: " + ctx.expression().getText());

                    boolean bShouldWiden = false;

                    if (!primitiveType.equals(rhsType)) {
                        if (rhsType.widensTo(primitiveType)) {
                            bShouldWiden = true;
                        } else {
                            System.out.println("Type mismatch! Expected " + primitiveType + " found " + rhsType);
                            return generateCompilerError("VARINIT_TYPE_MISMATCH_EXPECTED_" + primitiveType + "_FOUND_" + rhsType, ctx);
                        }
                    }

                    return visit(ctx.expression()) + (bShouldWiden ? " " + ASMUtil.generateCastAssembly(rhsType, primitiveType) : "") + ASMUtil.generateStoreAddress(address);
                }
                return "";
            } else {
                if (getCurrentScope().findScopeContaining(ctx.ID().getText()) != null) {
                    System.out.println("Symbol was already defined in this scope! " + ctx.ID().getText());
                    return generateCompilerError("SYMBOL_REDEFINITION_" + ctx.ID().getText(), ctx);
                }

                if (ctx.expression() != null) {
                    if (ctx.expression() instanceof UISCParser.NumberLiteralExpressionContext) {
                        UISCParser.NumberLiteralExpressionContext expression = (UISCParser.NumberLiteralExpressionContext) ctx.expression();

                        TypedValue constantValue;

                        if (expression.number().INT() != null) {
                            constantValue = new TypedValue(primitiveType, Long.parseLong(expression.number().INT().getText()));
                        } else {
                            constantValue = new TypedValue(Float.parseFloat(expression.number().FLOAT().getText()));
                        }

                        getCurrentScope().declareConstantInlineSymbol(ctx.ID().getText(), constantValue);
                        System.out.println(">>Defined constant " + ctx.ID().getText() + " of type " + constantValue.type + " with value " + constantValue);
                        return "";
                    } else {
                        System.out.println("Cannot use that rvalue as a constant!");
                        return generateCompilerError("INVALID_CONSTANT_RVALUE_" + ctx.ID().getText(), ctx);
                    }
                }
                System.out.println("Must specify constant value!");
                return generateCompilerError("INVALID_CONSTANT_" + ctx.ID().getText(), ctx);
            }
        }

        if (ctx.type().structType() != null) {
            if (ctx.type().pointer() != null) {
                throw new UnsupportedOperationException("Struct pointers are not yet implemented.");
            }

            int address = getCurrentScope().declareStruct(ctx.ID().getText(), ctx.type().structType().getText());

            if (address < 0) {
                System.out.println("Struct symbol was already defined in this scope! " + ctx.ID().getText());
                return generateCompilerError("STRUCT_SYMBOL_REDEFINITION_" + ctx.ID().getText(), ctx);
            }

            if (ctx.expression() != null) {
                throw new UnsupportedOperationException("Assigning struct values on initialization is not yet supported.");
            }

            System.out.println(">>Initialized struct symbol " + ctx.ID().getText() + " of type " + ctx.type().structType().getText() + " with address " + address);
            return getCurrentScope().findStructDefinition(ctx.type().getText()).generateAllocatorASM() + ASMUtil.generateStoreAddress(address);
        }

        throw new UnsupportedOperationException("Invalid variable initialization: " + ctx.getText());
    }

    /**
     * End Initialization
     */


    @Override
    public String visitFunctionCallStatement(UISCParser.FunctionCallStatementContext ctx) {
        if (ctx.expression() instanceof UISCParser.FunctionCallExpressionContext) {
            UISCParser.FunctionCallExpressionContext call = (UISCParser.FunctionCallExpressionContext) ctx.expression();
            ScopeBase scopeContaining = getCurrentScope().findScopeContaining(call.ID().getText());
            if (scopeContaining == null) {
                return generateCompilerError("Function " + call.ID().getText() + " was not defined in this scope.", ctx);
            }

            ScopeWithSymbol functionSymbol = (ScopeWithSymbol) scopeContaining.getSymbol(call.ID().getText());

            if (functionSymbol == null) {
                return generateCompilerError("Function " + call.ID().getText() + " was not properly defined in this scope.", ctx);
            }

            if (functionSymbol.Symbol.type.equals(PrimitiveType.Void)) {
                return visit(ctx.expression()); // this function call doesnt return a value
            }
            return generateCompilerWarning("Result of function call is ignored.", ctx) + visit(ctx.expression()) + " drop"; // this function call doesnt use the retval, drop it. like:  add(1,2);
        }

        if (ctx.expression() instanceof UISCParser.NativeCallExpressionContext) {
            UISCParser.NativeCallExpressionContext call = (UISCParser.NativeCallExpressionContext) ctx.expression();
            PrimitiveType nativeCallType = call.accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));
            if (PrimitiveType.Void.equals(nativeCallType)) {
                return visit(ctx.expression()); // this function call doesnt return a value
            }
            return generateCompilerWarning("Result of function call is ignored.", ctx) + visit(ctx.expression()) + " drop"; // this function call doesnt use the retval, drop it. like:  add(1,2);
        }

        if (ctx.expression() instanceof UISCParser.PostfixOpExpressionContext || ctx.expression() instanceof UISCParser.PrefixOpExpressionContext) {
            return super.visitFunctionCallStatement(ctx) + " drop"; // this call doesnt use the retval, drop it.
        }

        return generateCompilerWarning("Warning: Ignoring unused statement.", ctx);
    }


    /**
     * Begin Statements
     */

    @Override
    public String visitIncludeStatement(UISCParser.IncludeStatementContext ctx) {
        if (fileSystem == null) return "INCLUDE_STATEMENT_ERROR_NULL_FILESYSTEM";
        if (ctx.include() != null && ctx.include().STRING() != null) {
            String pathQuoted = ctx.include().STRING().getText();
            String path = pathQuoted.substring(1, pathQuoted.length() - 1);
            if (fileSystem.exists(path) && fileSystem.isFile(path)) {
                if (path.toLowerCase().endsWith(".uisc")) {
                    return generateCompilerError("INCLUDE_STATEMENT_ERROR_CANNOT_HANDLE_UISC_FILES_AT_THIS_LEVEL", ctx);
                }
                if (path.toLowerCase().endsWith(".uiscb")) {
                    return ASMUtil.generateComment("Begin Included Binary File: " + path) + "0x" + BytesUtil.bytesToHex(fileSystem.getFileAsBytes(path)) + ASMUtil.generateComment("End Included Binary File: " + path) + "\n";
                } else {
                    return generateCompilerError("INCLUDE_STATEMENT_ERROR_FILE_UNKNOWN_EXTENSION_" + path, ctx);
                }
            } else {
                return generateCompilerError("INCLUDE_STATEMENT_ERROR_FILE_NOT_FOUND_" + path, ctx);
            }
        }
        return generateCompilerError("INCLUDE_STATEMENT_ERROR_INVALID_SYNTAX", ctx);
    }

    @Override
    public String visitFlagStatement(UISCParser.FlagStatementContext ctx) {
        if (ctx.flag() != null && ctx.flag().INT() != null) {
            return "flag " + Integer.parseInt(ctx.flag().INT().getText());
        }
        return "INVALID_FLAG_STATEMENT_SYNTAX";
    }

    @Override
    public String visitFlagDataStatement(UISCParser.FlagDataStatementContext ctx) {
        return "flagdata " + ctx.flagData().getChild(2).getText()+" " + ctx.flagData().getChild(4).getText(); // asm compiler handles strings and hex strings
    }

    @Override
    public String visitTryCatchStatement(UISCParser.TryCatchStatementContext ctx) {
        StringBuilder tryCatchAsm = new StringBuilder();

        // maybe record depth here so we can drop back to that depth?
        // put inside a virtualscript so returns are caught
        // execute and jumpif over the catch block if returned true

        // ScopeCapture captureScope = PushLocalScopeCapture("TryStatement");

        //depth push {fxn} call verify

        PushLocalScope("TryStatement");

        if (ctx.catchStatement() == null) {
            // try without catch. just ignores returns
            tryCatchAsm.append(" depth " + ASMUtil.generatePushASMString(visit(ctx.tryStatement())) + " call drop ");
        } else {
            String endLabel = getNextLabel();
            tryCatchAsm.append(" depth " + ASMUtil.generatePushASMString(visit(ctx.tryStatement())) + " call gotoif " + endLabel);
            tryCatchAsm.append(visit(ctx.catchStatement())); // catch block
            tryCatchAsm.append(" :" + endLabel);
        }

        PopLocalScope();

        //  return ASMUtil.generateComment("Try statement ") + captureScope.generateCaptureASM() + tryCatchAsm.toString();


/*        if(ctx.catchStatement() != null){
            PushLocalScope("CatchStatement");

            PopLocalScope();
        } else {
            // clean up exceptions?
        }
        /// drop back to that depth?*/

        return tryCatchAsm.toString();
    }

    @Override
    public String visitException(UISCParser.ExceptionContext ctx) {
        return ASMUtil.generateComment("Exception " + ctx.getText()) + visit(ctx.exprList()) + " return ";
    }

    @Override
    public String visitAssignmentStatement(UISCParser.AssignmentStatementContext ctx) {
        if (ctx.lhs == null) {
            ScopeBase scopeContainingStruct = getCurrentScope().findScopeContaining(ctx.lhs_struct.structname.getText());

            if (scopeContainingStruct == null) {
                return generateCompilerError("Undefined struct " + ctx.lhs_struct.structname.getText(), ctx);
            }

            SymbolStruct symbol = (SymbolStruct) scopeContainingStruct.getSymbol(ctx.lhs_struct.structname.getText());

            if (ctx.lhs_struct.structArrayIndex != null) {
                throw new UnsupportedOperationException("Array of structs not yet implemented.");
            }

            if (symbol.struct == null) {
                throw new UnsupportedOperationException("Struct $" + symbol.address + " " + ctx.lhs_struct.structname.getText() + " symbol is null");
            }

            PrimitiveStructOrArrayType structField = symbol.struct.getFieldType(ctx.lhs_struct.fieldname.getText());

            if (structField.isStruct()) {
                throw new UnsupportedOperationException("Struct as member of struct not yet implemented");
            }

            if (structField.PrimitiveType == null) {
                return generateCompilerError("Undefined field " + ctx.lhs_struct.structname.getText() + "." + ctx.lhs_struct.fieldname.getText(), ctx);
            }

            PrimitiveType rhsType = ctx.rhs.accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));

            boolean bShouldWiden = false;

            if (!structField.PrimitiveType.equals(rhsType)) {
                if (rhsType.widensTo(structField.PrimitiveType)) {
                    bShouldWiden = true;
                } else {
                    return generateCompilerError("Type mismatch! Expected " + structField.PrimitiveType + " found " + rhsType, ctx);
                }
            }

            if (ctx.lhs_struct.fieldArrayIndex != null) {
                if (!structField.isArray()) {
                    throw new UnsupportedOperationException("Struct field array access but struct field is not array! " + ctx.lhs_struct.toString());
                }
                // value to set                                                                                                   struct base address                 struct field setter
                ///////////////////////////////////////////////////

                PrimitiveType indexType = ctx.lhs_struct.fieldArrayIndex.accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));

                PrimitiveStructOrArrayType fieldType = symbol.struct.getFieldType(ctx.lhs_struct.fieldname.getText());

                return visit(ctx.rhs) +
                        (bShouldWiden ? " " + ASMUtil.generateCastAssembly(rhsType, fieldType.PrimitiveType) : " ") +
                        //"push "+symbol.address+" "+ // push stack element
                        ASMUtil.generatePushNumberLiteralCast(Integer.toString(symbol.address), PrimitiveType.Int32) +//
                        visit(ctx.lhs_struct.fieldArrayIndex) + " " +
                        ASMUtil.generateCastAssembly(indexType, PrimitiveType.Int32) +// push array index auto casted to int
                        (fieldType.PrimitiveType.getSize() == 1 ? "" : (ASMUtil.generatePushNumberLiteralCast(Integer.toString(fieldType.PrimitiveType.getSize()), PrimitiveType.Int32) + " multiply")) + // multiply by sizeof to get beginIndex, unless SizeOf is 1
                        (symbol.struct.getFieldByteIndex(ctx.lhs_struct.fieldname.getText()) != 0 ? (ASMUtil.generatePushNumberLiteralCast(Integer.toString(symbol.struct.getFieldByteIndex(ctx.lhs_struct.fieldname.getText())), PrimitiveType.Int32) + " add") : "") +    // add struct field offset
                        ASMUtil.generatePushNumberLiteralCast(Integer.toString(fieldType.PrimitiveType.getSize()), PrimitiveType.Int32) +
                        //" push "+fieldType.PrimitiveType.getSize()+
                        " set ";  // push sizeof

                //////////////////////////////////////////////////

            }

            if (structField.isPrimitive()) {
                // value to set                                                                                                                                                 struct base address                               struct field setter
                return visit(ctx.rhs) + (bShouldWiden ? " " + ASMUtil.generateCastAssembly(rhsType, structField.PrimitiveType) : "") + ASMUtil.generatePushNumberLiteralCast(Integer.toString(symbol.address), PrimitiveType.Int32) + symbol.struct.generateFieldSetterASM(ctx.lhs_struct.fieldname.getText());
            }
            //todo struct as struct member

            throw new UnsupportedOperationException("Assign value to struct array member? " + ctx.getText());
        }

        ScopeBase scopeContaining = getCurrentScope().findScopeContaining(ctx.lhs.getText());

        if (scopeContaining == null) {
            return generateCompilerError("Undefined symbol " + ctx.ID().getText(), ctx);
        }

        if (scopeContaining.getSymbol(ctx.lhs.getText()) instanceof TypedValue) {
            return generateCompilerError("Assigning to constant " + ctx.ID().getText(), ctx);
        }

        if (scopeContaining.getSymbol(ctx.lhs.getText()) instanceof SymbolStruct) {
            throw new UnsupportedOperationException("Assigning whole struct values not yet supported.");
        }

        SymbolBase symbol = (SymbolBase) scopeContaining.getSymbol(ctx.lhs.getText());

        if (symbol == null) {
            return generateCompilerError("Undefined symbol " + ctx.lhs.getText(), ctx);
        }

        PrimitiveType rhsType = ctx.rhs.accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));

        boolean bShouldWiden = false;

        if (!symbol.type.equals(rhsType)) {
            if (rhsType.widensTo(symbol.type)) {
                bShouldWiden = true;
            } else {
                return generateCompilerError("Type mismatch! Expected " + symbol.type + " found " + rhsType, ctx);
            }
        }

        if (ctx.arrayIndex == null) {
            //return visit(ctx.rhs) + (bShouldWiden ? " " + ASMUtil.generateCastAssembly(rhsType, symbol.type) : "") + " push [" + symbol.address + "] put";
            return visit(ctx.rhs) + (bShouldWiden ? " " + ASMUtil.generateCastAssembly(rhsType, symbol.type) : "") + symbol.generateSetSymbolASM();
        } else {
            PrimitiveType indexType = ctx.arrayIndex.accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));
            return ASMUtil.generateComment("Assignment statement " + ctx.getText()) + visit(ctx.rhs) + (bShouldWiden ? " " + ASMUtil.generateCastAssembly(rhsType, symbol.type) : " ") +
                    ASMUtil.generateStoreArrayElement(symbol.address, visit(ctx.arrayIndex) + " " + ASMUtil.generateCastAssembly(indexType, PrimitiveType.Int32), symbol.type.getSize());
/*            return ASMUtil.generateComment("Assignment statement "+ctx.getText()) + visit(ctx.rhs) + (bShouldWiden ? " " + ASMUtil.generateCastAssembly(rhsType, symbol.type) : " ") +
                    "push "+symbol.address+" "+ // push stack element
                    visit(ctx.arrayIndex) +" "+ ASMUtil.generateCastAssembly(indexType, PrimitiveType.Int32) +// push array index auto casted to int
                    (symbol.type.getSize() == 1 ? "" : ("push "+ symbol.type.getSize()+ // multiply by sizeof to get beginIndex, unless SizeOf is 1
                            " multiply"))+
*//*
                    " push "+symbol.type.getSize()+ // multiply by sizeof to get beginIndex
                    " multiply "+*//*

                    " push "+symbol.type.getSize()+
                    " set ";  // push sizeof*/

            // return visit(ctx.rhs) + (bShouldWiden ? " " + ASMUtil.generateCastAssembly(rhsType, symbol.type) : "") + " push " + symbol.address + " " + visit(ctx.arrayIndex) + " push " + /*sizeof type*/symbol.type.getSize() + " set";
        }
    }

    @Override
    public String visitOpAndAssignmentStatement(UISCParser.OpAndAssignmentStatementContext ctx) {
        String opAsm = null;

        switch (ctx.op.getText()) {
            case "+=" -> {
                opAsm = "add";
            }
            case "-=" -> {
                opAsm = "subtract";
            }
            case "*=" -> {
                opAsm = "multiply";
            }
            case "/=" -> {
                opAsm = "divide";
            }
            case "&=" -> {
                opAsm = "bitand";
            }
            case "|=" -> {
                opAsm = "bitor";
            }
            case "%=" -> {
                opAsm = "modulo";
            }
        }

        if (opAsm == null) {
            throw new UnsupportedOperationException("Invalid operator: " + ctx.op.getText());
        }

        ScopeBase scopeContaining = getCurrentScope().findScopeContaining(ctx.lhs.getText());

        if (scopeContaining == null) {
            return generateCompilerError("Undefined symbol " + ctx.lhs.getText(), ctx);
        }

        SymbolBase symbol = (SymbolBase) scopeContaining.getSymbol(ctx.lhs.getText());

        PrimitiveType rhsType = ctx.rhs.accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));

        if (rhsType != null && rhsType.widensTo(symbol.type)) {


            return symbol.generateGetSymbolASM() + " " + visit(ctx.rhs) + " " + opAsm + " " + symbol.generateSetSymbolASM();
        } else {
            return generateCompilerError("Type mismatch! Expected " + symbol.type + " found " + rhsType, ctx);
        }
    }

    @Override
    public String visitReturnStatement(UISCParser.ReturnStatementContext ctx) {
        if (ctx.retval == null) return " nop";
        PrimitiveType returnedType = ctx.retval.accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));

        RuleContext parent = ctx.parent;
        while (parent != null && !(parent instanceof UISCParser.FunctionDeclarationContext)) parent = parent.parent;
        UISCParser.FunctionDeclarationContext functionDeclaration = (UISCParser.FunctionDeclarationContext) parent;

        if (functionDeclaration == null) {
            return generateCompilerError("Return outside of function declaration " + ctx.getText(), ctx);
        } else {
            PrimitiveType definedReturnType = PrimitiveType.getByKeyword(functionDeclaration.type().getText());
            if (returnedType.widensTo(definedReturnType)) {
                return ASMUtil.generateComment("Return statement " + ctx.getText()) + " " + visit(ctx.retval) + " " + ASMUtil.generateCastAssembly(returnedType, definedReturnType);
            } else {
                return generateCompilerError("Type mismatch! Expected " + definedReturnType + " found " + returnedType, ctx);
            }
        }
    }

    @Override
    public String visitIfStatement(UISCParser.IfStatementContext ctx) {
        String ifBlockLabel = getNextLabel();
        ArrayList<String> elseIfLabels = new ArrayList<>();

        for (UISCParser.ElseifStatementContext elseifStatementContext : ctx.elseifStatement()) {
            elseIfLabels.add(getNextLabel());
        }

        String endLabel = getNextLabel();

        StringBuilder asm = new StringBuilder();

        if (ctx.elseifStatement().size() == 0) { // optimized if no else ifs
            /*
            if()
            condition
            gotoif true
            FALSEBLOCK
            goto end
            :true
            TRUEBLOCK
            :end
             */

            asm.append(visit(ctx.conditional)); // condition
            asm.append(" gotoif ").append(ifBlockLabel).append(" "); // gotoif true
            PushLocalScope("IfStatement_ElseBlock");
            if (ctx.elseStatement() != null) asm.append(visit(ctx.elseStatement())); // falseblock
            PopLocalScope();
            asm.append(" goto ").append(endLabel); // goto end
            asm.append(" :").append(ifBlockLabel).append(" "); // :true
            PushLocalScope("IfStatement_IfBlock");
            asm.append(visit(ctx.ifbody)); // TRUEBLOCK
            PopLocalScope();
            asm.append(" :").append(endLabel); //:end

        } else {
             /*

        if ()
        condition
        gotoif true

        else if()
        condition
        gotoif eliftrue1

        else if()
        condition
        gotoif eliftrue2

        else()
        ELSEBLOCK
        goto end
        :true
        TRUEBLOCK
        goto end

        :eliftrue1
           ELIFTRUE1BLOCK
          goto end

       :eliftrue2
           ELIFTRUE2BLOCK
          goto end

        :end

         */

            asm.append(visit(ctx.conditional)); // condition
            asm.append(" gotoif ").append(ifBlockLabel).append(" "); // gotoif true

            for (int i = 0; i < ctx.elseifStatement().size(); i++) {
                asm.append(visit(ctx.elseifStatement().get(i).conditional)); // elif condition
                asm.append(" gotoif ").append(elseIfLabels.get(i)).append(" "); // goto elif N
            }

            // else
            asm.append(visit(ctx.elseStatement())).append(" goto ").append(endLabel); // ELSEBLOCK goto end

            asm.append(" :").append(ifBlockLabel).append(" "); // :true
            asm.append(visit(ctx.ifbody)); // TRUEBLOCK
            asm.append(" goto ").append(endLabel); // goto end

            for (int i = 0; i < ctx.elseifStatement().size(); i++) {
                PushLocalScope("IfStatement_ElseIfBlock_" + i);
                asm.append(" :").append(elseIfLabels.get(i)).append(" "); // :elifN
                asm.append(visit(ctx.elseifStatement().get(i)));
                if (i < ctx.elseifStatement().size() - 1) asm.append(" goto ").append(endLabel); // goto end (skip last)
                PopLocalScope();
            }

            asm.append(" :").append(endLabel); // :end
        }

        return ASMUtil.generateComment("If statement " + ctx.conditional.getText()) + asm.toString();
    }

    @Override
    public String visitUforiStatement(UISCParser.UforiStatementContext ctx) { // loop unrolling
        int ItBegin, ItEnd;

        if (ctx.iterationsEnd != null) {
            ItBegin = Integer.parseInt(ctx.iterations.getText());
            ItEnd = Integer.parseInt(ctx.iterationsEnd.getText());
        } else {
            ItEnd = Integer.parseInt(ctx.iterations.getText());
            ItBegin = 0;
        }

        PushLocalScope("ForIStatement");


        //  int IteratorAddress = getCurrentScope().declareSymbol(ctx.ID().getText(), Type.getByKeyword(ctx.type().getText()));

        StringBuilder forIStatement = new StringBuilder();

        for (int i = ItBegin; i < ItEnd; i++) {
            PushLocalScope("ForIStatement_Inner_" + i);
            getCurrentScope().declareConstantInlineSymbol(ctx.ID().getText(), new TypedValue(PrimitiveType.getByKeyword(ctx.type().getText()), i));
            forIStatement.append(visit(ctx.forbody));
            PopLocalScope();
        }

        PopLocalScope();

        return ASMUtil.generateComment("For I Statement " + ItBegin + ", " + ItEnd) + forIStatement.toString();
    }

    @Override
    public String visitUforeachStatement(UISCParser.UforeachStatementContext ctx) { // loop unrolling
        ScopeBase scopeContaining = getCurrentScope().findScopeContaining(ctx.arrayToLoop.getText());
        if (scopeContaining == null) {
            return generateCompilerError("Array " + ctx.ID().getText() + " was not defined in this scope.", ctx);
        }

        SymbolArray symbol = (SymbolArray) scopeContaining.getSymbol(ctx.ID().getText());

        if (symbol == null) {
            return generateCompilerError("Array " + ctx.ID().getText() + " was not properly defined in this scope.", ctx);
        }

        PushLocalScope("ForEachStatement_" + ctx.ID().getText());

        StringBuilder forEachStatement = new StringBuilder();

        if (ctx.varDeclaration() instanceof UISCParser.VarInitializationContext) {
            UISCParser.VarInitializationContext varDeclaration = (UISCParser.VarInitializationContext) ctx.varDeclaration();

            PrimitiveType varType = PrimitiveType.getByKeyword(varDeclaration.type().getText());

            if (!symbol.type.widensTo(varType)) {
                return generateCompilerError("The foreach element was not the correct type. " + varDeclaration.getText(), ctx);
            }

            if (varDeclaration.constant != null || varDeclaration.expression() != null || varType == null) {
                return generateCompilerError("The foreach element was not properly defined. It cannot be a constant or assigned a value and must have a type. " + varDeclaration.getText(), ctx);
            }

            for (int i = 0; i < symbol.length; i++) {
                PushLocalScope("ForEachStatement_" + ctx.arrayToLoop.getText() + "_Inner_" + i);

                int varAddress = getCurrentScope().declareSymbol(varDeclaration.ID().getText(), varType);
//todo off by one to the right? dont think so anymore
                forEachStatement.append("push " + symbol.address + // push stack element
                        " push " + i +// push array index
                        " push " + symbol.type.getSize() + // multiply by sizeof to get beginIndex
                        " multiply push " + symbol.type.getSize() +
                        " get " + ASMUtil.generateCastAssembly(symbol.type, varType) + // auto widen to foreach var type
                        ASMUtil.generateStoreAddress(varAddress) // put the array element into the foreach var
                );

                forEachStatement.append(visit(ctx.forbody));

                PopLocalScope();
            }

        }

        PopLocalScope();

        return ASMUtil.generateComment("ForEach Statement " + ctx.arrayToLoop.getText()) + forEachStatement.toString();

    }

    @Override
    public String visitAssertion(UISCParser.AssertionContext ctx) {
        return ASMUtil.generateComment("Assertion " + ctx.getText()) + visit(ctx.expression()) + " verify";
    }


    /** End Statements */


    /**
     * Begin Expressions
     */

    @Override
    public String visitComparisonExpression(UISCParser.ComparisonExpressionContext ctx) {
        switch (ctx.op.getText()) {
            case "<" -> {
                return getCastedBinaryExpression(ctx.lhs, ctx.rhs, " lessthan", " lessthan", ctx);
            }
            case "<=" -> {
                return getCastedBinaryExpression(ctx.lhs, ctx.rhs, " lessthanequal", " lessthanequal", ctx);
            }
            case ">" -> {
                return getCastedBinaryExpression(ctx.lhs, ctx.rhs, " greaterthan", " greaterthan", ctx);
            }
            case ">=" -> {
                return getCastedBinaryExpression(ctx.lhs, ctx.rhs, " greaterthanequal", " greaterthanequal", ctx);
            }
            default -> {
                throw new UnsupportedOperationException("Unknown comparison operator: " + ctx.op.getText());
            }
        }
    }

    @Override
    public String visitAssembly(UISCParser.AssemblyContext ctx) {
        return ASMUtil.generateComment("Raw ASM " + ctx.getText()) + stripQuotesFromString(ctx.STRING().getText());
    }

    @Override
    public String visitModuloExpression(UISCParser.ModuloExpressionContext ctx) {
        return getCastedBinaryExpression(ctx.lhs, ctx.rhs, "modulo", "convertfloatto32 swap convertfloatto32 swap modulo convert32tofloat", ctx); // dont think there is float mod
    }

    @Override
    public String visitAddressOfVariableExpression(UISCParser.AddressOfVariableExpressionContext ctx) {
        ScopeBase scopeContaining = getCurrentScope().findScopeContaining(ctx.ID().getText());

        if (scopeContaining == null) {
            return generateCompilerError("Undefined symbol " + ctx.ID().getText(), ctx);
        }

        Object uncastedSymbol = scopeContaining.getSymbol(ctx.ID().getText());

        if (uncastedSymbol instanceof TypedValue) {
            return generateCompilerError("Cannot get the address of constant " + ctx.ID().getText(), ctx);
        }

        SymbolBase symbol = (SymbolBase) uncastedSymbol;

        if (symbol == null) {
            return generateCompilerError("Undefined symbol " + ctx.ID().getText(), ctx);
        }
        return ASMUtil.generateComment("Address Of variable " + ctx.getText()) + ASMUtil.generatePushNumberLiteralCast(Integer.toString(symbol.address), PrimitiveType.Int32);
    }

    @Override
    public String visitLengthOfExpression(UISCParser.LengthOfExpressionContext ctx) { // this will return number of bytes in array, not number of elements. divide by sizeof
        return ASMUtil.generateComment("Length of " + ctx.getText()) + visit(ctx.expression()) + " len swap drop"; // this removes the value which we took the length of
    }

    @Override
    public String visitSizeOfExpression(UISCParser.SizeOfExpressionContext ctx) {
        PrimitiveType sizeOfType = PrimitiveType.getByKeyword(ctx.type().getText());
        if (sizeOfType == null) {
            return generateCompilerError("Invalid type! Cannot determine size of invalid type " + ctx.type().getText(), ctx);
        }

        return ASMUtil.generateComment("SizeOf " + ctx.getText()) + "push [" + sizeOfType.getSize() + "]";
    }


    @Override
    public String visitBitwiseExpression(UISCParser.BitwiseExpressionContext ctx) {
        if (ctx.op.getText().contains("&")) {
            return getCastedBinaryExpression(ctx.lhs, ctx.rhs, "bitand", "bitand", ctx);
        }
        if (ctx.op.getText().contains("|")) {
            return getCastedBinaryExpression(ctx.lhs, ctx.rhs, "bitor", "bitor", ctx);
        }
        if (ctx.op.getText().contains("^")) {
            return getCastedBinaryExpression(ctx.lhs, ctx.rhs, "bitxor", "bitxor", ctx);
        }
        if (ctx.op.getText().contains("~")) {
            return getCastedBinaryExpression(ctx.lhs, ctx.rhs, "bitnot", "bitnot", ctx);
        }
        return super.visitBitwiseExpression(ctx);
    }

    @Override
    public String visitTernaryExpression(UISCParser.TernaryExpressionContext ctx) {
        String truelabel = getNextLabel();
        String falselabel = getNextLabel();
        return ASMUtil.generateComment("Ternary " + ctx.getText()) + visit(ctx.condition) + " gotoif " + truelabel + " " + visit(ctx.iffalse) + " goto " + falselabel + " :" + truelabel + " " + visit(ctx.iftrue) + " :" + falselabel;
    }

    @Override
    public String visitValueAtVariableExpression(UISCParser.ValueAtVariableExpressionContext ctx) {
        PrimitiveType exprType = ctx.expression().accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope)).fromPointer();
        String castAssembly = ASMUtil.generateCastAssembly(exprType, PrimitiveType.Byte);
        return (exprType == PrimitiveType.Void ? generateCompilerWarning("Warning: ValueAt of non pointer (" + ctx.expression().getText() + ") returns unknown type (void)!", ctx) : "") + ASMUtil.generateComment("Get Value At variable " + ctx.getText()) + visit(ctx.expression()) + castAssembly + " pick ";
    }

    @Override
    public String visitCastExpression(UISCParser.CastExpressionContext ctx) {
        PrimitiveType fromType = ctx.expression().accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));

        if (ctx.type().primitiveType() != null) {
            PrimitiveType toType = ctx.type().pointer() == null ? PrimitiveType.getByKeyword(ctx.type().primitiveType().getText()) : PrimitiveType.getByKeyword(ctx.type().primitiveType().getText()).toPointer();

            String castAssembly = ASMUtil.generateCastAssembly(fromType, toType);

            if (castAssembly == null) {
                return generateCompilerError("Type mismatch! Cannot cast from " + fromType + " to " + toType, ctx);
            }

            return ASMUtil.generateComment("Cast " + ctx.getText()) + visit(ctx.expression()) + " " + castAssembly;
        }

        if(ctx.type().inferredType() != null) {
            ParserRuleContext parent = ctx.getParent();

            while(parent instanceof UISCParser.ParenExpressionContext) {
                parent = parent.getParent();
            }

            if(parent instanceof UISCParser.CastExpressionContext) {
                PrimitiveType primitiveType = parent.accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));
                String castAssembly = ASMUtil.generateCastAssembly(fromType, primitiveType);

                if (castAssembly == null) {
                    return generateCompilerError("Type mismatch! Cannot cast from " + fromType + " to " + primitiveType, ctx);
                }
                return ASMUtil.generateComment("Cast " + ctx.getText()) + visit(ctx.expression()) + " " + castAssembly;
            }

            if(parent instanceof UISCParser.AssignmentStatementContext) {
                UISCParser.AssignmentStatementContext assignmentStatementContext = (UISCParser.AssignmentStatementContext) parent;
                if(assignmentStatementContext.lhs != null) {
                    ScopeBase scopeContaining = getCurrentScope().findScopeContaining(assignmentStatementContext.lhs.getText());

                    if (scopeContaining == null) {
                        return generateCompilerError("Undefined symbol " + assignmentStatementContext.lhs.getText(), ctx);
                    }

                    if (scopeContaining.getSymbol(assignmentStatementContext.lhs.getText()) instanceof TypedValue) {
                        return generateCompilerError("Assigning to constant " + assignmentStatementContext.lhs.getText(), ctx);
                    }

                    if (scopeContaining.getSymbol(assignmentStatementContext.lhs.getText()) instanceof SymbolStruct) {
                        throw new UnsupportedOperationException("Assigning whole struct values not yet supported.");
                    }

                    SymbolBase symbol = (SymbolBase) scopeContaining.getSymbol(assignmentStatementContext.lhs.getText());
                    String castAssembly = ASMUtil.generateCastAssembly(fromType, symbol.type);

                    if (castAssembly == null) {
                        return generateCompilerError("Type mismatch! Cannot cast from " + fromType + " to " + symbol.type, ctx);
                    }

                    return ASMUtil.generateComment("Cast " + ctx.getText()) + visit(ctx.expression()) + " " + castAssembly;
                }
            }

            if(parent instanceof UISCParser.ReturnStatementContext) {
                ParserRuleContext context = parent;
                do {
                    context = context.getParent();
                } while (!(context instanceof UISCParser.FunctionDeclarationContext));

                UISCParser.FunctionDeclarationContext functionDeclarationContext = (UISCParser.FunctionDeclarationContext) context;
                if(functionDeclarationContext.type().primitiveType() != null) {
                    PrimitiveType primitiveType = PrimitiveType.getByKeyword(functionDeclarationContext.type().primitiveType().getText());
                    String castAssembly = ASMUtil.generateCastAssembly(fromType, primitiveType);

                    if (castAssembly == null) {
                        return generateCompilerError("Type mismatch! Cannot cast from " + fromType + " to " + primitiveType, ctx);
                    }
                    return ASMUtil.generateComment("Cast " + ctx.getText()) + visit(ctx.expression()) + " " + castAssembly;
                } else {
                    throw new UnsupportedOperationException("Auto/struct return type auto cast?");
                }
            }

            if(parent instanceof UISCParser.ExprListContext) {
                UISCParser.ExprListContext exprListContext = (UISCParser.ExprListContext) parent;
                List<UISCParser.ExpressionContext> expression = exprListContext.expression();
                int exprListIndex = -1;
                for (int i = 0; i < expression.size(); i++) {
                    if(expression.get(i).equals(ctx)) {
                        exprListIndex = i;
                        break;
                    }
                }

                if(exprListIndex < 0 || exprListIndex >= exprListContext.expression().size()) {
                    throw new UnsupportedOperationException("Failed to find expression in exprList!");
                }

                List<Class<? extends ParserRuleContext>> parents = List.of(
                        UISCParser.NativeCallExpressionContext.class,
                        UISCParser.CatchStatementContext.class,
                        UISCParser.ExceptionContext.class,
                        UISCParser.FunctionCallExpressionContext.class,
                        UISCParser.ArrayValueInitializationContext.class);

                ParserRuleContext context = parent;
                do {
                    context = context.getParent();
                } while (!(parents.contains(context.getClass())));

                if(context instanceof UISCParser.FunctionCallExpressionContext) {
                    UISCParser.FunctionCallExpressionContext functionCallExpressionContext = (UISCParser.FunctionCallExpressionContext) context;
                    String functionId = functionCallExpressionContext.ID().getText();
                    ScopeBase scopeContaining = getCurrentScope().findScopeContaining(functionId);
                    if(scopeContaining != null) {
                        Object symbol = scopeContaining.getSymbol(functionId);
                        if(symbol instanceof ScopeWithSymbol) {
                            ScopeWithSymbol scopeWithSymbol = (ScopeWithSymbol) symbol;
                            PrimitiveType primitiveType = scopeWithSymbol.Symbol.getTypeOfParameter(exprListIndex);
                            String castAssembly = ASMUtil.generateCastAssembly(fromType, primitiveType);

                            if (castAssembly == null) {
                                return generateCompilerError("Type mismatch! Cannot cast from " + fromType + " to " + primitiveType, ctx);
                            }
                            return ASMUtil.generateComment("Cast " + ctx.getText()) + visit(ctx.expression()) + " " + castAssembly;
                        }
                    }
                }

                if(context instanceof UISCParser.NativeCallExpressionContext) {
                    UISCParser.NativeCallExpressionContext nativeCallExpressionContext = (UISCParser.NativeCallExpressionContext) context;
                    String nativeId = nativeCallExpressionContext.ID().getText();

                    SymbolFunction nativeDefinition = Global.getNativeDefinition(nativeId);
                    PrimitiveType primitiveType = nativeDefinition.getTypeOfParameter(exprListIndex);
                    String castAssembly = ASMUtil.generateCastAssembly(fromType, primitiveType);

                    if (castAssembly == null) {
                        return generateCompilerError("Type mismatch! Cannot cast from " + fromType + " to " + primitiveType, ctx);
                    }
                    return ASMUtil.generateComment("Cast " + ctx.getText()) + visit(ctx.expression()) + " " + castAssembly;
                }

                if(context instanceof UISCParser.ArrayValueInitializationContext) {
                    UISCParser.ArrayValueInitializationContext arrayValueInitializationContext = (UISCParser.ArrayValueInitializationContext) context;
                    if(arrayValueInitializationContext.type().inferredType() != null) {
                        throw new UnsupportedOperationException("Cannot infer a cast to an inferred array type!");
                    }
                    PrimitiveType primitiveType = PrimitiveType.getByKeyword(arrayValueInitializationContext.type().primitiveType().getText());
                    String castAssembly = ASMUtil.generateCastAssembly(fromType, primitiveType);

                    if (castAssembly == null) {
                        return generateCompilerError("Type mismatch! Cannot cast from " + fromType + " to " + primitiveType, ctx);
                    }
                    return ASMUtil.generateComment("Cast " + ctx.getText()) + visit(ctx.expression()) + " " + castAssembly;
                }

                throw new UnsupportedOperationException("Auto cast in expression "+context.getClass().toString());
                // native
                // throw
                // catch
                // array initializer
            }

            ParseTree lhs = parent.getChild(0);
            if(lhs instanceof UISCParser.TypeContext) {
                UISCParser.TypeContext lhsType = (UISCParser.TypeContext) lhs;
                if(lhsType.inferredType() != null) {
                    return generateCompilerError("Cannot infer cast to inferred type.", ctx);
                }
                PrimitiveType primitiveType = PrimitiveType.getByKeyword(lhsType.primitiveType().getText());
                if(primitiveType == null) {
                    throw new UnsupportedOperationException("Autocasting to structs is not yet supported");
                }
                String castAssembly = ASMUtil.generateCastAssembly(fromType, primitiveType);

                if (castAssembly == null) {
                    return generateCompilerError("Type mismatch! Cannot cast from " + fromType + " to " + primitiveType, ctx);
                }

                return ASMUtil.generateComment("Cast " + ctx.getText()) + visit(ctx.expression()) + " " + castAssembly;
            } else {
                throw new UnsupportedOperationException("This type of autocast is not yet implemented: "+ parent.getClass().toString()+" -> " + lhs.getClass().toString());
            }
        }

        throw new UnsupportedOperationException("Cannot cast to type: " + ctx.type().getText());
    }

    @Override
    public String visitEqualityExpression(UISCParser.EqualityExpressionContext ctx) {
        return getCastedBinaryExpression(ctx.lhs, ctx.rhs, " bytesequal" + (ctx.op.getText().contains("!=") ? " not" : ""), " bytesequal" + (ctx.op.getText().contains("!=") ? " not" : ""), ctx);
        //return visit(ctx.lhs) + " " + visit(ctx.rhs) + " bytesequal" + (ctx.op.getText().contains("!=") ? " not" : "");
    }

    @Override
    public String visitNegateExpression(UISCParser.NegateExpressionContext ctx) {
/*        if(ctx.expression() instanceof UISCParser.NumberLiteralExpressionContext) { // if number literal, negate the literal // todo asm cant handle -INT
            return "push -" + ((UISCParser.NumberLiteralExpressionContext)ctx.expression()).number().getText();
        }*/
        // todo negate fails on byte. fix this and we can remove below
        PrimitiveType fromType = ctx.expression().accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));

        if (PrimitiveType.Byte.equals(fromType)) {
            return visit(ctx.expression()) + " convert8to32 negate convert32to8";
        } else {
            return visit(ctx.expression()) + " negate";
        }
    }

    @Override
    public String visitNotExpression(UISCParser.NotExpressionContext ctx) {
        return visit(ctx.expression()) + " not";
    }

    @Override
    public String visitAddSubExpression(UISCParser.AddSubExpressionContext ctx) {
        if (ctx.lhs instanceof UISCParser.StringLiteralExpressionContext || (ctx.lhs instanceof UISCParser.VariableReferenceExpressionContext && // is this array concat?
                getCurrentScope().findScopeContaining(((UISCParser.VariableReferenceExpressionContext) ctx.lhs).ID().getText()) != null &&
                getCurrentScope().findScopeContaining(((UISCParser.VariableReferenceExpressionContext) ctx.lhs).ID().getText()).getSymbol(((UISCParser.VariableReferenceExpressionContext) ctx.lhs).ID().getText()) instanceof SymbolArray)) {
            // todo this will throw off symbol array lengths, so uforeach wouldnt work. dont see how this can work unless the sizes are fixed. maybe use set 0, len*size instead? to force user to create new array long enough
            // yeah could be a void that takes a pointer to fill in
            return getCastedBinaryExpression(ctx.lhs, ctx.rhs, "append", "append", ctx);
        }

        if (ctx.op.getText().contains("+")) {
            return getCastedBinaryExpression(ctx.lhs, ctx.rhs, "add", "addfloat", ctx);
        }
        if (ctx.op.getText().contains("-")) {
            return getCastedBinaryExpression(ctx.lhs, ctx.rhs, "subtract", "subtractfloat", ctx);
        }
        return super.visitAddSubExpression(ctx);
    }

    @Override
    public String visitMultDivExpression(UISCParser.MultDivExpressionContext ctx) {
        if (ctx.op.getText().contains("*")) {
            return getCastedBinaryExpression(ctx.lhs, ctx.rhs, "multiply", "multiplyfloat", ctx);
        }
        if (ctx.op.getText().contains("/")) {
            return getCastedBinaryExpression(ctx.lhs, ctx.rhs, "divide", "dividefloat", ctx);
        }
        return super.visitMultDivExpression(ctx);
    }

    @Override
    public String visitAndOrXorExpression(UISCParser.AndOrXorExpressionContext ctx) {
        if (ctx.lhs instanceof UISCParser.BooleanLiteralExpressionContext && ctx.rhs instanceof UISCParser.BooleanLiteralExpressionContext) { // optimization. could optimize more by checking if the result of visit is false or true
            if (ctx.op.getText().contains("&&")) {
                return Boolean.parseBoolean(visit(ctx.lhs)) && Boolean.parseBoolean(visit(ctx.rhs)) ? "true" : "false";
            }
            if (ctx.op.getText().contains("||")) {
                return Boolean.parseBoolean(visit(ctx.lhs)) || Boolean.parseBoolean(visit(ctx.rhs)) ? "true" : "false";
            }
            if (ctx.op.getText().contains("^^")) {
                return Boolean.parseBoolean(visit(ctx.lhs)) ^ Boolean.parseBoolean(visit(ctx.rhs)) ? "true" : "false";
            }
        }

        if (ctx.op.getText().contains("&&")) {
            return visit(ctx.lhs) + " " + visit(ctx.rhs) + " " + "and";
        }
        if (ctx.op.getText().contains("||")) {
            return visit(ctx.lhs) + " " + visit(ctx.rhs) + " " + "or";
        }
        if (ctx.op.getText().contains("^^")) {
            return visit(ctx.lhs) + " " + visit(ctx.rhs) + " " + "xor";
        }
        return super.visitAndOrXorExpression(ctx);
    }

    @Override
    public String visitVariableReferenceExpression(UISCParser.VariableReferenceExpressionContext ctx) {
        ScopeBase scopeContaining = getCurrentScope().findScopeContaining(ctx.ID().getText());

        if (scopeContaining == null) {
            return generateCompilerError("Undefined symbol " + ctx.ID().getText(), ctx);
        }

        Object uncastedSymbol = scopeContaining.getSymbol(ctx.ID().getText());

        if (uncastedSymbol instanceof TypedValue) { // constant
            return ((TypedValue) uncastedSymbol).generateGetSymbolASM();
            //return "push "+((TypedValue)uncastedSymbol);
        }

        SymbolBase symbol = (SymbolBase) uncastedSymbol;

        if (symbol == null) {
            return generateCompilerError("Undefined symbol " + ctx.ID().getText(), ctx);
        }
        return ASMUtil.generateComment("Variable reference " + ctx.getText()) + symbol.generateGetSymbolASM();
        //return "push [" + symbol.address + "] pick ";
    }

    @Override
    public String visitFunctionCallExpression(UISCParser.FunctionCallExpressionContext ctx) {
        ScopeBase scopeContaining = getCurrentScope().findScopeContaining(ctx.ID().getText());
        if (scopeContaining == null) {
            return generateCompilerError("Function " + ctx.ID().getText() + " was not defined or is not in scope.", ctx);
        }

        ScopeWithSymbol functionSymbol = (ScopeWithSymbol) scopeContaining.getSymbol(ctx.ID().getText());

        if (functionSymbol == null) {
            return generateCompilerError("Function " + ctx.ID().getText() + " was not properly defined.", ctx);
        }

        if (ctx.exprList() != null) {
            int numParamsProvided = ctx.exprList().expression().size();
            if (functionSymbol.Symbol.getNumberOfParameters() != numParamsProvided) {
                return generateCompilerError("Function " + ctx.ID().getText() + " expects " + functionSymbol.Symbol.getNumberOfParameters() + " but only " + numParamsProvided + " were provided.", ctx);
            }
        }

        StringBuilder sb = new StringBuilder();

        if (ctx.exprList() != null) {
            List<UISCParser.ExpressionContext> expression = ctx.exprList().expression();
            for (int i = 0; i < expression.size(); i++) {
                PrimitiveType providedType = expression.get(i).accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));
                if (providedType.widensTo(functionSymbol.Symbol.getTypeOfParameter(i))) {
                    sb.append(ASMUtil.generateComment("Function parameter " + functionSymbol.Symbol.getNameOfParameter(i)));
                    sb.append(visit(expression.get(i))).append(" ").append(ASMUtil.generateCastAssembly(providedType, functionSymbol.Symbol.getTypeOfParameter(i)));
                    // todo generate store address is giving addresses already occupied
                    sb.append(ASMUtil.generateStoreAddress(((Symbol) functionSymbol.getSymbol(functionSymbol.Symbol.getNameOfParameter(i))).getSymbolAddress()));
                } else {
                    return generateCompilerError("Function " + ctx.ID().getText() + " expects " + functionSymbol.Symbol.getTypeOfParameter(i) + " for parameter " + functionSymbol.Symbol.getNameOfParameter(i) + " but " + providedType + " was provided.", ctx);
                }
            }
        }

        return sb.toString() + ASMUtil.generateComment("Function call " + ctx.getText()) + // params
                " depth " +//capture whole stack so we can reference globals. OR do we want to make functions unable to modify global state, only return
                // if we give the whole stack to functions, then parameters can just refer to their original position if they are var refs.
                // functions dont need to modify global state if we move to a main method
                // " push ["+ctx.exprList().expression().size()+"] "+ // number of parameters
                functionSymbol.generateGetSymbolASM() +
                //" push [" + functionSymbol.Symbol.address + "] pick"+ // get function bytecode
                "call verify ";// +// execute and ensure it did not fail
        //     "push ["+ctx.exprList().expression().size()+"] dropn "; // drop function parameters
    }

    @Override
    public String visitArrayAccessExpression(UISCParser.ArrayAccessExpressionContext ctx) {
        // this is always r value
        ScopeBase scopeContaining = getCurrentScope().findScopeContaining(ctx.ID().getText());
        if (scopeContaining == null) {
            return generateCompilerError("Array " + ctx.ID().getText() + " was not defined in this scope.", ctx);
        }

        SymbolBase symbol = (SymbolBase) scopeContaining.getSymbol(ctx.ID().getText());

        if (symbol == null) {
            return generateCompilerError("Array " + ctx.ID().getText() + " was not properly defined in this scope.", ctx);
        }

        int SizeOf = symbol.type.getSize();

        PrimitiveType indexExpressionType = ctx.expression().accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));

        String castAssembly = ASMUtil.generateCastAssembly(indexExpressionType, PrimitiveType.Int32);

        if (castAssembly == null) {
            return generateCompilerError("Array " + ctx.ID().getText() + " access with unsupported type: " + indexExpressionType, ctx);
        }

        return ASMUtil.generateLoadArrayElement(symbol.address, visit(ctx.expression()) + " " + castAssembly, SizeOf);
/*        return ASMUtil.generateComment("Array access "+ctx.getText()) + "push "+symbol.address+" "+ // push stack element
                visit(ctx.expression())+" "+ castAssembly +// push array index auto casted to int
                (SizeOf == 1 ? "" : (" push "+SizeOf+ // multiply by sizeof to get beginIndex, unless SizeOf is 1
                " multiply"))+
                " push "+SizeOf+
                " get ";  // push sizeof*/
    }

    @Override
    public String visitStructFieldReferenceExpression(UISCParser.StructFieldReferenceExpressionContext ctx) {
        ScopeBase scopeContaining = getCurrentScope().findScopeContaining(ctx.structField().structname.getText());
        if (scopeContaining == null) {
            return generateCompilerError("Struct " + ctx.structField().structname.getText() + " was not defined in this scope.", ctx);
        }

        SymbolStruct symbol = (SymbolStruct) scopeContaining.getSymbol(ctx.structField().structname.getText());

        if (symbol == null) {
            System.out.println();
            return generateCompilerError("Struct " + ctx.structField().structname.getText() + " was not properly defined in this scope.", ctx);
        }

        return " push " + symbol.address + symbol.struct.generateFieldGetterASM(ctx.structField().fieldname.getText());
    }

    private static final Map<String, String> nativeToOp = Map.of("encrypt", "encryptaes", "decrypt", "decryptaes", "pow", "exponent", "verifySig", "verifysig verify", "len", "len swap drop");

    @Override
    public String visitNativeCallExpression(UISCParser.NativeCallExpressionContext ctx) {
        SymbolFunction nativeDefinition = Global.getNativeDefinition(ctx.ID().getText());

        List<PrimitiveType> ParamsExpected = new ArrayList<>();
        for (int i = 0; i < nativeDefinition.getNumberOfParameters(); i++) {
            ParamsExpected.add(nativeDefinition.getTypeOfParameter(i));
        }

        if (ParamsExpected.size() != 0 && ctx.exprList().expression() == null) {
            return generateCompilerError("NATIVE_CALL_" + ctx.ID().getText() + "_EXPECTED_" + ParamsExpected + "_PARAMETERS_FOUND_0", ctx);
        }

        if (((ctx.exprList() == null && ParamsExpected.size() > 0)) || ctx.exprList() != null && ctx.exprList().expression().size() != ParamsExpected.size()) {
            return generateCompilerError("NATIVE_CALL_" + ctx.ID().getText() + "_EXPECTED_" + ParamsExpected + "_PARAMETERS_FOUND_" + ctx.exprList().expression().size(), ctx);
        }

        StringBuilder sb = new StringBuilder();

        List<UISCParser.ExpressionContext> expression = ctx.exprList().expression();
        for (int i = 0; i < expression.size(); i++) {
            PrimitiveType providedType = expression.get(i).accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));

            if(ctx.ID().getText().equalsIgnoreCase("sizeof")) {
                return " push "+providedType.getSize();
            }

            if (providedType.widensTo(ParamsExpected.get(i))) {
                // push param
                sb.append(ASMUtil.generateComment("Native parameter " + i + ParamsExpected.get(i).name()));
                // auto widen
                sb.append(visit(expression.get(i))).append(" ").append(ASMUtil.generateCastAssembly(providedType, ParamsExpected.get(i)));
            } else {
                return generateCompilerError("Native " + ctx.ID().getText() + " expects " + ParamsExpected.get(i) + " for parameter " + i + " but " + providedType + " was provided.", ctx);
            }
        }

        return sb.append(" ").append(nativeToOp.containsKey(ctx.ID().getText()) ? nativeToOp.get(ctx.ID().getText()) : ctx.ID().getText()).toString();
    }

    @Override
    public String visitPostfixOpExpression(UISCParser.PostfixOpExpressionContext ctx) {

        if (ctx.parent instanceof UISCParser.StatementContext) {
            return generateCompilerError("Use prefix increment if you don't need postfix. " + ctx.getText(), ctx);
        }

        PrimitiveType expressionType = ctx.expression().accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));

        //++ doesnt make sense for anything but an id, array access, or struct member access
        if (ctx.expression() instanceof UISCParser.VariableReferenceExpressionContext) {
            String originalVariableName = ((UISCParser.VariableReferenceExpressionContext) ctx.expression()).ID().getText();
            int originalAddress = ((SymbolBase) getCurrentScope().findScopeContaining(originalVariableName).getSymbol(originalVariableName)).address;

            // dup x, add 1,  store to original address, (leaving original x on the stack)
            return visit(ctx.expression()) + " dup true " + ASMUtil.generateCastAssembly(PrimitiveType.Byte, expressionType) + (ctx.op.getText().equals("++") ? " add " : " subtract ") + ASMUtil.generateStoreAddress(originalAddress);
        }

        if (ctx.expression() instanceof UISCParser.ArrayAccessExpressionContext) {
            throw new UnsupportedOperationException("Postfix increment array access NYI");
        }

        if (ctx.expression() instanceof UISCParser.StructFieldReferenceExpressionContext) {
            throw new UnsupportedOperationException("Postfix increment struct field NYI");
        }

        throw new UnsupportedOperationException("Postfix increment is not supported in this context. " + ctx.getText());
    }

    @Override
    public String visitPrefixOpExpression(UISCParser.PrefixOpExpressionContext ctx) {
        PrimitiveType expressionType = ctx.expression().accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));
        if (!expressionType.isNumeric()) {
            return generateCompilerError("Cannot " + ctx.op + " non-numeric expression " + ctx.expression().getText(), ctx);
        }

        // for a var ref, array access or struct member we need to store the result
        if (ctx.expression() instanceof UISCParser.VariableReferenceExpressionContext) {
            String originalVariableName = ((UISCParser.VariableReferenceExpressionContext) ctx.expression()).ID().getText();
            int originalAddress = ((SymbolBase) getCurrentScope().findScopeContaining(originalVariableName).getSymbol(originalVariableName)).address;

            return visit(ctx.expression()) + " true " + ASMUtil.generateCastAssembly(PrimitiveType.Byte, expressionType) + (ctx.op.getText().equals("--") ? "subtract " : "add ") + "dup " + ASMUtil.generateStoreAddress(originalAddress);
        }

        if (ctx.expression() instanceof UISCParser.ArrayAccessExpressionContext) {
            throw new UnsupportedOperationException("Prefix increment array access NYI");
        }

        if (ctx.expression() instanceof UISCParser.StructFieldReferenceExpressionContext) {
            throw new UnsupportedOperationException("Prefix increment struct field NYI");
        }
        // otherwise we just add to it
        return visit(ctx.expression()) + " true " + ASMUtil.generateCastAssembly(PrimitiveType.Byte, expressionType) + (ctx.op.getText().equals("--") ? "subtract " : "add ");
    }

    /**
     * End Expressions
     */


    @Override
    public String visitArrayValueInitialization(UISCParser.ArrayValueInitializationContext ctx) { // todo could be optimized into a single push. would that be smaller? // todo type check
        if (getCurrentScope().hasSymbol(ctx.ID().getText())) {
            return generateCompilerError("Symbol " + ctx.ID().getText() + " was already defined in this scope!", ctx);
        }

        PrimitiveType arrayType = ctx.arrayInitializer().accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));
        PrimitiveType expectedType;
        if(ctx.type().primitiveType() != null) {
            expectedType = PrimitiveType.getByKeyword(ctx.type().getText());
            if (arrayType == null || (!arrayType.equals(expectedType) && !arrayType.widensTo(expectedType))) {
                return generateCompilerError("Array " + ctx.ID().getText() + " was not properly initialized: type mismatch expected " + expectedType + " found " + arrayType, ctx);
            }
        } else {
            expectedType = arrayType;
        }

        // auto widens using visitArrayInitializer();
        return generateCompilerWarning("ArrayValueInitialization assumes each array initializer expression pushes exactly one value onto the stack.", ctx) + ASMUtil.generateComment("Array value initialization " + ctx.getText()) + visit(ctx.arrayInitializer()) +
                " push [" + ctx.arrayInitializer().exprList().expression().size() + "] combine " +
                ASMUtil.generateStoreAddress(getCurrentScope().declareArray(ctx.ID().getText(), expectedType, ctx.arrayInitializer().exprList().expression().size()));//" push [" + getCurrentScope().declareArray(ctx.ID().getText(), expectedType, ctx.arrayInitializer().exprList().expression().size()) + "] put";
    }

    // this is how we auto widen array initializers
    @Override
    public String visitArrayInitializer(UISCParser.ArrayInitializerContext ctx) {
        if (!(ctx.getParent() instanceof UISCParser.ArrayValueInitializationContext)) {
            return generateCompilerError("Array Initializer is not part of array value initialization!", ctx);
        }
        UISCParser.ArrayValueInitializationContext parent = (UISCParser.ArrayValueInitializationContext) ctx.getParent();

        PrimitiveType castToType;
        if(parent.type().primitiveType() != null) {
            castToType = PrimitiveType.getByKeyword(parent.type().getText());
        } else {
            castToType = ctx.accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));
        }

        StringBuilder arrayInitializerAsm = new StringBuilder();

        for (UISCParser.ExpressionContext expressionContext : ctx.exprList().expression()) {
            PrimitiveType type = expressionContext.accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));
            arrayInitializerAsm.append(visit(expressionContext)).append(" ").append(ASMUtil.generateCastAssembly(type, castToType)).append(" ");
        }

        return ASMUtil.generateComment("Array initialization " + ctx.getText()) + arrayInitializerAsm.toString();
    }

    @Override
    public String visitStructDeclaration(UISCParser.StructDeclarationContext ctx) {
        ArrayList<NameAndType> Params = new ArrayList<>();

        for (UISCParser.VarDeclarationContext varDeclarationContext : ctx.varDeclaration()) {
            if (varDeclarationContext instanceof UISCParser.VarInitializationContext) {
                UISCParser.VarInitializationContext structField = (UISCParser.VarInitializationContext) varDeclarationContext;

                if (structField.constant != null) {
                    throw new UnsupportedOperationException("Constants are not allowed in structs (yet?)");
                }

                if (structField.type().primitiveType() == null) {
                    throw new UnsupportedOperationException("Nested structs are not currently supported");
                }

                Params.add(new NameAndType(structField.ID().getText(), new PrimitiveStructOrArrayType(structField.type().pointer() == null ? PrimitiveType.getByKeyword(structField.type().primitiveType().getText()) : PrimitiveType.getByKeyword(structField.type().primitiveType().getText()).toPointer())));
            } else if (varDeclarationContext instanceof UISCParser.ArrayAssignmentInitializationContext) {
                UISCParser.ArrayAssignmentInitializationContext structField = (UISCParser.ArrayAssignmentInitializationContext) varDeclarationContext;

                if (structField.expression() != null) {
                    throw new UnsupportedOperationException("That is not allowed right now");
                }

                if (structField.type().primitiveType() == null) {
                    throw new UnsupportedOperationException("Nested structs are not currently supported");
                }

                PrimitiveStructOrArrayType type = new PrimitiveStructOrArrayType(structField.type().pointer() == null ? PrimitiveType.getByKeyword(structField.type().primitiveType().getText()) : PrimitiveType.getByKeyword(structField.type().primitiveType().getText()).toPointer(), Integer.parseInt(structField.size.getText()));
                Params.add(new NameAndType(structField.ID().getText(), type));
            }
        }

        getCurrentScope().defineStruct(ctx.ID().getText(), Params);
        return "";
    }

    @Override
    public String visitFunctionDeclaration(UISCParser.FunctionDeclarationContext ctx) {
        System.out.println(">>Defined function " + ctx.type().getText() + " " + ctx.ID().getText() + " " + (ctx.formalParameters() == null ? "" : ctx.formalParameters().toStringTree().replaceAll("\\[(.*?)\\]", "").replace("(", "").replace(")", "")));

        PrimitiveType fxnType = PrimitiveType.getByKeyword(ctx.type().getText());

        if (fxnType == null) {
            throw new UnsupportedOperationException("Struct functions are not yet supported.");
        }

        if (ctx.block() == null) {
            return generateCompilerError("No code block was found for the function: " + ctx.ID().getText(), ctx);
        }

        if (ctx.ID().getText().equalsIgnoreCase("main")) {
            mainFunctionAsm = ASMUtil.generateComment("Main function declaration") + visit(ctx.block());
            return "";
        }

        if (!fxnType.equals(PrimitiveType.Void)) {
            Boolean doAllPathsReturn = ctx.block().accept(new ASMGenAllPathsReturnVisitor());
            if (doAllPathsReturn == null || !doAllPathsReturn) {
                return generateCompilerError("Not all paths return a value in a non void function! " + ctx.ID().getText(), ctx);
            }
        }

        ArrayList<NameAndType> Parameters = new ArrayList<>();

        if (ctx.formalParameters() != null) {
            for (UISCParser.FormalParameterContext formalParameterContext : ctx.formalParameters().formalParameter()) {
                Parameters.add(new NameAndType(formalParameterContext.ID().getText(), new PrimitiveStructOrArrayType(PrimitiveType.getByKeyword(formalParameterContext.type().getText()))));
            }
        }

        PushFunctionScope(fxnType, ctx.ID().getText(), Parameters);

        if (ctx.formalParameters() != null) {
            for (UISCParser.FormalParameterContext formalParameterContext : ctx.formalParameters().formalParameter()) {
                getCurrentScope().declareSymbol(formalParameterContext.ID().getText(), PrimitiveType.getByKeyword(formalParameterContext.type().getText()));
            }
        }

        String functionCode = visit(ctx.block());
        //int NumberOfParameters = getCurrentScope().size(); // we capture all for now so we dont have to deal with ScopeCapture
        int FunctionAddress = ((ScopeWithSymbol) getCurrentScope().findScopeContaining(ctx.ID().getText()).getSymbol(ctx.ID().getText())).Symbol.address;

        PopLocalScope();

        return ASMUtil.generateComment("Function declaration " + ctx.ID().getText()) + "push { " + functionCode + "} " + ASMUtil.generateStoreAddress(FunctionAddress);//push [" + FunctionAddress + "] put";
    }
}
