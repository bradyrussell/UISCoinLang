/* (C) Brady Russell 2021 */
package com.bradyrussell.uiscoin.lang.compiler.scope;

import java.util.HashMap;
import java.util.stream.Collectors;

import com.bradyrussell.uiscoin.lang.compiler.ASMUtil;
import com.bradyrussell.uiscoin.lang.compiler.symbol.Symbol;
import com.bradyrussell.uiscoin.lang.compiler.symbol.SymbolArray;
import com.bradyrussell.uiscoin.lang.compiler.symbol.SymbolBase;

public class ScopeCapture extends ScopeLocal {
    public ScopeCapture(String scopeName, ScopeBase parent) {
        super(scopeName, parent);
        ScopeBaseAddress = 0; // capture always starts from zero
        ScopeAddress = 0;
    }

    HashMap<String, Integer> capturedVariableRealAddresses = new HashMap<>();

    // todo how to capture pointers?
    // another hashmap for pointers which we also capture and restore the contents?

    //todo change this to wrapCaptureASM(String InnerASM)
    public String generateCaptureASM(){
        // pick capturedVariableRealAddresses(x)
        // pick ..y
        //pick ..z    in order where symbolTable.get(x).address = 0, y = 1 etc

        StringBuilder sb = new StringBuilder();

        // todo capture constants by putting them in the symbol table too?

        return symbolTable.entrySet().stream().sorted((a, b)->{ // sort by capture local address
            if(a.getValue() instanceof Symbol && b.getValue() instanceof Symbol) {
                return ((Symbol)a.getValue()).getSymbolAddress() - ((Symbol)b.getValue()).getSymbolAddress();
            } else {
                throw new UnsupportedOperationException("Symbol table value is not symbol! "+a.getKey()+":"+a.getValue()+""+(a.getValue() instanceof Symbol)+" / "+b.getKey()+":"+b.getValue()+(b.getValue() instanceof Symbol));
            }
        }).map((stringObjectEntry -> {
            if(super.hasSymbol(stringObjectEntry.getKey())) { // local
                return ASMUtil.generateComment("Allocate space for "+stringObjectEntry.getKey()) + "null ";
            } else { // capture
                return ASMUtil.generateComment("Capture "+stringObjectEntry.getKey()) + "push ["+capturedVariableRealAddresses.get(stringObjectEntry.getKey())+"] pick ";
            }
        })).collect(Collectors.joining("\n"));

//        sb.append("\n/* Begin Capture of "+capturedVariableRealAddresses.size()+" Symbols */\n"); // todo this needs to do nulls for  non captured variables
//
//        symbolTable.entrySet().stream().filter((e)-> capturedVariableRealAddresses.containsKey(e.getKey())).sorted((a, b)->{
//            int aAddress = 0, bAddress = 0;
//
//            if(a.getValue() instanceof ScopeWithSymbol) {
//                aAddress = ((ScopeWithSymbol)a.getValue()).Symbol.address;
//            }
//            if(a.getValue() instanceof SymbolBase) {
//                aAddress = ((SymbolBase)a.getValue()).address;
//            }
//            if(b.getValue() instanceof ScopeWithSymbol) {
//                bAddress = ((ScopeWithSymbol)b.getValue()).Symbol.address;
//            }
//            if(b.getValue() instanceof SymbolBase) {
//                bAddress = ((SymbolBase)b.getValue()).address;
//            }
//            return aAddress - bAddress;
//        }).map(Map.Entry::getKey).map((s -> capturedVariableRealAddresses.get(s))).forEach((integer -> sb.append("push [").append(integer).append("] pick ")));
//
//        sb.append("\n/* End Capture of "+capturedVariableRealAddresses.size()+" Symbols */\n");

       // return sb.toString();
    }

    // return modifed values to their original state
    // this might need to be two separate functions, one called inside the scope and one outside
    public String generateRestoreCapturedValuesASM(){
        return null;
    }

    @Override
    public Object getSymbol(String Name) {
        if(symbolTable.containsKey(Name)) return symbolTable.get(Name);
        ScopeBase actualScope = super.findScopeContaining(Name);
        if(actualScope == null) return null;

        // capture the symbol into this scope
        Object uncastedActualSymbol = actualScope.getSymbol(Name);

        if(uncastedActualSymbol instanceof ScopeWithSymbol) {
            ScopeWithSymbol actualSymbol = (ScopeWithSymbol) uncastedActualSymbol;
            capturedVariableRealAddresses.put(Name, actualSymbol.Symbol.address);

            // todo functions need their scope captured?

        } else if(uncastedActualSymbol instanceof SymbolArray) {
            SymbolArray actualSymbol = (SymbolArray) uncastedActualSymbol;
            capturedVariableRealAddresses.put(Name, actualSymbol.address);

            int innerAddress = declareArray(Name, actualSymbol.type, actualSymbol.length);
            System.out.println("[Capture] Captured array "+Name+" outer address: "+actualSymbol.address+" inner address: "+innerAddress);
        } else {
            SymbolBase actualSymbol = (SymbolBase) uncastedActualSymbol;
            capturedVariableRealAddresses.put(Name, actualSymbol.address);

            int innerAddress = declareSymbol(Name, actualSymbol.type);
            System.out.println("[Capture] Captured symbol "+Name+" outer address: "+actualSymbol.address+" inner address: "+innerAddress);
        }
        return symbolTable.get(Name);
    }

    @Override
    public boolean hasSymbol(String Name) {
        if(super.hasSymbol(Name)) return true;
        ScopeBase actualScope = super.findScopeContaining(Name);
        return actualScope != null;
    }

    @Override
    public ScopeBase findScopeContaining(String Name) {
        if(hasSymbol(Name)) return this;
        return null;
    }
}
