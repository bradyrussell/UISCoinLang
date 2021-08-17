/* (C) Brady Russell 2021 */
package com.bradyrussell.uiscoin.lang.compiler;

import com.bradyrussell.uiscoin.lang.compiler.scope.ScopeBase;
import com.bradyrussell.uiscoin.lang.compiler.scope.ScopeGlobal;
import com.bradyrussell.uiscoin.lang.compiler.scope.ScopeLocal;
import com.bradyrussell.uiscoin.lang.compiler.scope.ScopeWithSymbol;
import com.bradyrussell.uiscoin.lang.compiler.symbol.SymbolBase;
import com.bradyrussell.uiscoin.lang.compiler.symbol.SymbolStruct;
import com.bradyrussell.uiscoin.lang.compiler.type.PrimitiveStructOrArrayType;
import com.bradyrussell.uiscoin.lang.compiler.type.PrimitiveType;
import com.bradyrussell.uiscoin.lang.compiler.type.TypedValue;
import com.bradyrussell.uiscoin.lang.generated.UISCParser;

import org.antlr.v4.runtime.tree.RuleNode;

public class ASMGenPrimitiveTypeVisitor extends ASMGenSubVisitorBase<PrimitiveType> {
    public ASMGenPrimitiveTypeVisitor(ScopeGlobal global, ScopeLocal currentLocalScope) {
        super(global, currentLocalScope);
    }

    @Override
    public PrimitiveType visitChildren(RuleNode node) {
        PrimitiveType type = super.visitChildren(node);
        if(type == null){
            System.out.println("[TypeChecker] Type visitor returned null! Cannot determine type for: "+node.getText());
        }
        return type;
    }

    @Override
    protected PrimitiveType defaultResult() {
        return null;
    }

    @Override
    protected PrimitiveType aggregateResult(PrimitiveType aggregate, PrimitiveType nextResult) {
        if(aggregate == null && nextResult != null) return nextResult;
        if(nextResult == null) return null;
        return PrimitiveType.getWiderType(aggregate, nextResult);
    }



    private PrimitiveType getCastedBinaryExpression(UISCParser.ExpressionContext LHS, UISCParser.ExpressionContext RHS){
        //Type lhsType = LHS.accept(new ASMGenTypeVisitor(Global, CurrentLocalScope));
        //Type rhsType = RHS.accept(new ASMGenTypeVisitor(Global, CurrentLocalScope));
        PrimitiveType lhsType = visit(LHS);
        PrimitiveType rhsType = visit(RHS);

        if(lhsType == null || rhsType == null) {
            System.out.println("Type null! Cannot determine type: " + lhsType + " and " + rhsType);
            return null;
        }

        return PrimitiveType.getWiderType(lhsType, rhsType);
    }

/*    @Override
    public Type visitVarInitialization(UISCParser.VarInitializationContext ctx) {
        return ctx.pointer() != null ? Type.getByKeyword(ctx.type().getText()).toPointer() : Type.getByKeyword(ctx.type().getText());
    }*/

    @Override
    public PrimitiveType visitVariableReferenceExpression(UISCParser.VariableReferenceExpressionContext ctx) {
        ScopeBase scopeContaining = getCurrentScope().findScopeContaining(ctx.ID().getText());
        if(scopeContaining == null) {
            System.out.println("Cannot deduce type of undefined variable: "+ctx.ID().getText());
            return null;
        }

        Object uncastedSymbol = scopeContaining.getSymbol(ctx.ID().getText());
        if(uncastedSymbol instanceof TypedValue) {
            return ((TypedValue)uncastedSymbol).type;
        }

        SymbolBase symbol = (SymbolBase) uncastedSymbol;
        if(symbol == null) {
            System.out.println("Cannot deduce type of function as variable: "+ctx.ID().getText());
            return null;
        }
        return symbol.type;
    }

    @Override
    public PrimitiveType visitBooleanLiteral(UISCParser.BooleanLiteralContext ctx) {
        return ctx.getText().equals("null") ? PrimitiveType.Void : PrimitiveType.Byte;
    }

    @Override
    public PrimitiveType visitNumberLiteralExpression(UISCParser.NumberLiteralExpressionContext ctx) {
        return PrimitiveType.deduceTypeOfNumber(ctx.number().getText());
    }

    @Override
    public PrimitiveType visitStringLiteralExpression(UISCParser.StringLiteralExpressionContext ctx) {
        return PrimitiveType.Byte; // byte array
    }

    @Override
    public PrimitiveType visitCharLiteralExpression(UISCParser.CharLiteralExpressionContext ctx) {
        return PrimitiveType.Byte;
    }

    @Override
    public PrimitiveType visitArrayInitializer(UISCParser.ArrayInitializerContext ctx) {
        PrimitiveType lastType = null;
        for (UISCParser.ExpressionContext expressionContext : ctx.exprList().expression()) {
            if(lastType == null) {
                lastType = visit(expressionContext);
            } else {
                lastType = PrimitiveType.getWiderType(lastType, visit(expressionContext));
            }
        }
        return lastType;
    }

    @Override
    public PrimitiveType visitNativeCallExpression(UISCParser.NativeCallExpressionContext ctx) {
        switch (ctx.ID().getText()) {
            case "encrypt","decrypt","zip","unzip","sha512","get" ->{
                return PrimitiveType.ByteArray;
            }
            case "verifySig","copy","set" -> {
                return PrimitiveType.Void;
            }
            case "instruction" -> {
                return PrimitiveType.Int32;
            }
        }
        throw new UnsupportedOperationException("Type not defined for native: "+ctx.getText());
    }

    @Override
    public PrimitiveType visitFunctionCallExpression(UISCParser.FunctionCallExpressionContext ctx) {
        ScopeBase scopeContaining = getCurrentScope().findScopeContaining(ctx.ID().getText());
        if(scopeContaining == null) {
            System.out.println("Cannot deduce type of undefined function: "+ctx.ID().getText());
            return null;
        }
        ScopeWithSymbol symbol = (ScopeWithSymbol) scopeContaining.getSymbol(ctx.ID().getText());
        if(symbol == null) {
            System.out.println("Cannot deduce type of variable as function: "+ctx.ID().getText());
            return null;
        }
        return symbol.Symbol.type;
    }

    @Override
    public PrimitiveType visitModuloExpression(UISCParser.ModuloExpressionContext ctx) {
        return getCastedBinaryExpression(ctx.lhs, ctx.rhs);
    }

    @Override
    public PrimitiveType visitAndOrExpression(UISCParser.AndOrExpressionContext ctx) {
        return getCastedBinaryExpression(ctx.lhs, ctx.rhs);
    }

    @Override
    public PrimitiveType visitMultDivExpression(UISCParser.MultDivExpressionContext ctx) {
        return getCastedBinaryExpression(ctx.lhs, ctx.rhs);
    }

    @Override
    public PrimitiveType visitAddSubExpression(UISCParser.AddSubExpressionContext ctx) {
        return getCastedBinaryExpression(ctx.lhs, ctx.rhs);
    }

    @Override
    public PrimitiveType visitEqualityExpression(UISCParser.EqualityExpressionContext ctx) {
        return getCastedBinaryExpression(ctx.lhs, ctx.rhs);
    }

    @Override
    public PrimitiveType visitBitwiseExpression(UISCParser.BitwiseExpressionContext ctx) {
        return getCastedBinaryExpression(ctx.lhs, ctx.rhs);
    }

    @Override
    public PrimitiveType visitTernaryExpression(UISCParser.TernaryExpressionContext ctx) {
        PrimitiveType commonType = getCastedBinaryExpression(ctx.iftrue, ctx.iffalse);
        if(commonType == null){
            System.out.println("Warning: Cannot find common type for ternary expression, returning void pointer. "+ctx.toString());
            return PrimitiveType.VoidPointer;
        }
        return commonType;
    }

    @Override
    public PrimitiveType visitAddressOfVariableExpression(UISCParser.AddressOfVariableExpressionContext ctx) {
        ScopeBase scopeContaining = getCurrentScope().findScopeContaining(ctx.ID().getText());
        if(scopeContaining == null) {
            System.out.println("Cannot deduce type of undefined variable: "+ctx.ID().getText());
            return null;
        }

        Object uncasted = scopeContaining.getSymbol(ctx.ID().getText());

        if(uncasted instanceof ScopeWithSymbol || uncasted instanceof SymbolStruct) { // address of function
            return PrimitiveType.VoidPointer; // function ptr
        } else {
            SymbolBase symbol = (SymbolBase)uncasted;
            if(symbol.type == null) {
                throw new UnsupportedOperationException("Unable to determine pointer type;");
            } else {
                return  symbol.type.toPointer();
            }
        }
    }

    @Override
    public PrimitiveType visitPostfixOpExpression(UISCParser.PostfixOpExpressionContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public PrimitiveType visitPrefixOpExpression(UISCParser.PrefixOpExpressionContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public PrimitiveType visitCastExpression(UISCParser.CastExpressionContext ctx) {
        PrimitiveType primitiveType = PrimitiveType.getByKeyword(ctx.type().primitiveType().getText());
        if(primitiveType == null) {
            throw new UnsupportedOperationException("Casting to structs is not yet supported");
        }
        return ctx.type().pointer() == null ? primitiveType : primitiveType.toPointer();
    }

    @Override
    public PrimitiveType visitParenExpression(UISCParser.ParenExpressionContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public PrimitiveType visitLengthOfExpression(UISCParser.LengthOfExpressionContext ctx) {
        return PrimitiveType.Int32;
    }

    @Override
    public PrimitiveType visitArrayAccessExpression(UISCParser.ArrayAccessExpressionContext ctx) {
        // this is always r value
        ScopeBase scopeContaining = getCurrentScope().findScopeContaining(ctx.ID().getText());
        if (scopeContaining == null) {
            System.out.println("Array " + ctx.ID().getText() + " was not defined in this scope.");
            return null;
        }

        SymbolBase symbol = (SymbolBase) scopeContaining.getSymbol(ctx.ID().getText());

        if (symbol == null) {
            System.out.println("Array " + ctx.ID().getText() + " was not properly defined in this scope.");
            return null;
        }

        return symbol.type/*.fromArray()*/;
    }

    @Override
    public PrimitiveType visitSizeOfExpression(UISCParser.SizeOfExpressionContext ctx) {
        PrimitiveType sizeOfType = PrimitiveType.getByKeyword(ctx.type().getText());
        if (sizeOfType == null) return null;
        return PrimitiveType.deduceTypeOfNumber(""+sizeOfType.getSize());
    }

    @Override
    public PrimitiveType visitValueAtVariableExpression(UISCParser.ValueAtVariableExpressionContext ctx) {
        PrimitiveType pointedType = visit(ctx.expression());
        if(pointedType == null) {
            System.out.println("Warning: Cannot find type for valueAt, returning void. "+ctx.toString());
            return PrimitiveType.Void;
        }
        return pointedType.fromPointer();
    }

    @Override
    public PrimitiveType visitStructFieldReferenceExpression(UISCParser.StructFieldReferenceExpressionContext ctx) {
        ScopeBase scopeContaining = getCurrentScope().findScopeContaining(ctx.structField().structname.getText());
        if (scopeContaining == null) {
            System.out.println("Struct " + ctx.structField().structname.getText() + " was not defined in this scope.");
            return null;
        }

        SymbolStruct symbol = (SymbolStruct) scopeContaining.getSymbol(ctx.structField().structname.getText());

        if (symbol == null) {
            System.out.println("Struct " + ctx.structField().structname.getText() + " was not properly defined in this scope.");
            return null;
        }

        if(symbol.struct.getFieldByteIndex(ctx.structField().fieldname.getText()) == -1) {
            throw new UnsupportedOperationException("This field does not exist on the struct: "+ctx.structField().getText()+
                    symbol.struct.toString());
        }

        PrimitiveStructOrArrayType fieldType = symbol.struct.getFieldType(ctx.structField().fieldname.getText());
        if(fieldType == null) throw new UnsupportedOperationException("Could not understand struct fieldname type: "+ctx.structField().fieldname.getText());

        if(fieldType.isStruct()) throw new UnsupportedOperationException("Struct as member of struct NYI: "+ fieldType);

        if(fieldType.isArray() && ctx.structField().fieldArrayIndex != null) return fieldType.PrimitiveType; // accessing array elem not whole array

        return fieldType.isArray() ? fieldType.PrimitiveType.toArray() : fieldType.PrimitiveType;
    }
}