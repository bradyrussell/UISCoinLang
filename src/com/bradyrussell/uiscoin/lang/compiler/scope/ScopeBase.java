/* (C) Brady Russell 2021 */
package com.bradyrussell.uiscoin.lang.compiler.scope;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.bradyrussell.uiscoin.lang.compiler.symbol.*;
import com.bradyrussell.uiscoin.lang.compiler.type.*;

public class ScopeBase {
    public String ScopeName = "AnonymousScope";
    public ScopeBase Parent;
    public ArrayList<ScopeBase> Children = new ArrayList<>();
    protected HashMap<String, Object> symbolTable = new HashMap<>(); // can either be SymbolBase or SymbolWithScope
    protected HashMap<String, StructDefinition> structDefinitions = new HashMap<>();

    protected int ScopeBaseAddress = 0; // 0 is heap
    protected int ScopeAddress;

    public ScopeBase(ScopeBase parent) {
        Parent = parent;
        if(parent !=  null) ScopeBaseAddress = parent.ScopeAddress;
        ScopeAddress = ScopeBaseAddress;
    }

    public ScopeBase(String scopeName, ScopeBase parent) {
        ScopeName = scopeName;
        Parent = parent;
        if(parent !=  null) ScopeBaseAddress = parent.ScopeAddress;
        ScopeAddress = ScopeBaseAddress;
        System.out.println("[Scope] Entering new scope "+scopeName+", base address: "+ScopeAddress+", parent: "+(Parent == null ? "None" : Parent.ScopeName));
    }

    public ScopeLocal defineFunction(String Name, PrimitiveType SymbolType, List<NameAndType> Parameters){
        if(symbolTable.containsKey(Name)) return null;

        SymbolFunction symbol = new SymbolFunction(SymbolType, ScopeAddress++);

        for (NameAndType parameter : Parameters) {
            symbol.defineParameter(parameter.Name, parameter.Type.PrimitiveType);
        }

        ScopeWithSymbol scope = new ScopeWithSymbol(Name,this, symbol);
        symbolTable.put(Name, scope);
        System.out.println("[Scope] Defined function "+Name+" at address "+(ScopeAddress-1));
        return scope;
    }

    public boolean defineStruct(String Name, List<NameAndType> Fields){
        if(structDefinitions.containsKey(Name)) return false;
        structDefinitions.put(Name,new StructDefinition(this, Fields));
        System.out.println("[Scope] Defined struct "+Name+" with "+Fields.size()+" fields.");
        return true;
    }

    public static String getTupleName(List<PrimitiveStructOrArrayType> Fields) {
        StringBuilder sb = new StringBuilder("tuple");
        for (PrimitiveStructOrArrayType field : Fields) {
            sb.append("_").append(field.getRepresentation());
        }
        return sb.toString();
    }

    public boolean defineTuple(List<PrimitiveStructOrArrayType> Fields){
        if(getRootScope().structDefinitions.containsKey(getTupleName(Fields))) return false;
        ArrayList<NameAndType> namedTypes = new ArrayList<>();
        for (int i = 0; i < Fields.size(); i++) {
            namedTypes.add(new NameAndType("t"+i, Fields.get(i)));
        }
        getRootScope().structDefinitions.put(getTupleName(Fields),new StructDefinition(this, namedTypes));
        System.out.println("[Scope] Defined tuple "+getTupleName(Fields)+" with "+Fields.size()+" fields.");
        return true;
    }

    public int declareSymbol(String Name, PrimitiveType SymbolType){
        if(symbolTable.containsKey(Name)) return -1;
        symbolTable.put(Name, new SymbolBase(SymbolType, ScopeAddress++));
        System.out.println("[Scope] Declared symbol "+Name+" at address "+(ScopeAddress-1));
        return ScopeAddress-1;
    }

    public int declareStruct(String Name, String StructType){
        if(symbolTable.containsKey(Name)) return -1;

        if(findStructDefinition(StructType) == null) {
            throw new UnsupportedOperationException("Undefined struct! "+StructType);
        }

        symbolTable.put(Name, new SymbolStruct(ScopeAddress++, findStructDefinition(StructType)));
        System.out.println("[Scope] Declared struct symbol "+Name+" of type "+StructType+" at address "+(ScopeAddress-1));
        return ScopeAddress-1;
    }

    public int declareTuple(String Name, List<PrimitiveStructOrArrayType> Types){
        if(symbolTable.containsKey(Name)) return -1;
        defineTuple(Types);
        symbolTable.put(Name, new SymbolStruct(ScopeAddress++, getRootScope().structDefinitions.get(getTupleName(Types))));
        System.out.println("[Scope] Declared tuple symbol "+Name+" of type "+getTupleName(Types)+" at address "+(ScopeAddress-1));
        return ScopeAddress-1;
    }

    public int declareArray(String Name, PrimitiveType SymbolType, int Length){
        if(symbolTable.containsKey(Name)) return -1;
        symbolTable.put(Name, new SymbolArray(SymbolType, ScopeAddress++, Length));
        System.out.println("[Scope] Declared array symbol "+Name+"["+Length+"] at address "+(ScopeAddress-1));
        return ScopeAddress-1;
    }

    public int declareConstantInlineSymbol(String Name, TypedValue Value){
        if(symbolTable.containsKey(Name)) return -1;
        symbolTable.put(Name, Value);
        System.out.println("[Scope] Declared constant inline symbol "+Name+" with value "+Value);
        return ScopeAddress-1;
    }

    public Object getSymbol(String Name){
        return symbolTable.get(Name);
    }

    public boolean hasSymbol(String Name){
        return symbolTable.containsKey(Name);
    }

    public int size(){
        return symbolTable.size();
    }

    @Override
    public String toString() {
        return "ScopeBase{" +
                "ScopeName='" + ScopeName + '\'' +
                ", Parent=" + (Parent == null ? "None":Parent.ScopeName) +
                ", Children=" + Children +
                ", symbolTable=" + symbolTable +
                ", ScopeAddress=" + ScopeAddress +
                ", ScopeBaseAddress=" + ScopeBaseAddress +
                '}';
    }

    public ScopeBase getRootScope() {
        if(Parent == null) {
            return this;
        }

        return Parent.getRootScope();
    }

    public ScopeBase findScopeContaining(String Name) {
        if(symbolTable.containsKey(Name)) return this;
        if(Parent == null) {
            //System.out.println("Symbol "+Name+" was not found in global scope "+ScopeName);
            return null;
        }

        //System.out.println("Symbol "+Name+" was not found in scope "+ScopeName);
        return Parent.findScopeContaining(Name);
    }

    public StructDefinition findStructDefinition(String StructType) {
        if(structDefinitions.containsKey(StructType)) return structDefinitions.get(StructType);
        if(Parent == null) {
            //System.out.println("Symbol "+Name+" was not found in global scope "+ScopeName);
            return null;
        }

        return Parent.findStructDefinition(StructType);
    }

    public String getRecursiveAllocation(){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < getDepth(); i++) {
            sb.append("null ");
        }

        return sb.toString();
    }

    public String getAllocation(){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ScopeAddress - ScopeBaseAddress; i++) {
            sb.append("null ");
        }

        return sb.toString();
    }

    public String getDeallocation(){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ScopeAddress - ScopeBaseAddress; i++) {
            sb.append("drop ");
        }

        return sb.toString();
    }

    // Brady is a nerd -AI

    public int getDepth(){
        int deepest = 0;
        int ThisDepth = ScopeAddress - ScopeBaseAddress;

        for (ScopeBase child : Children) {
            int childDepth = child.getDepth();
            if(childDepth > deepest) deepest = childDepth;
        }
        return ThisDepth + deepest;
    }
}
