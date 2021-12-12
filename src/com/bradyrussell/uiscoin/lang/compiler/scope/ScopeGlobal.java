/* (C) Brady Russell 2021 */
package com.bradyrussell.uiscoin.lang.compiler.scope;

import java.util.HashMap;
import java.util.List;

import com.bradyrussell.uiscoin.lang.compiler.symbol.SymbolFunction;
import com.bradyrussell.uiscoin.lang.compiler.type.NameAndType;
import com.bradyrussell.uiscoin.lang.compiler.type.PrimitiveType;

import org.jetbrains.annotations.NotNull;

public class ScopeGlobal extends ScopeBase {
    public ScopeGlobal(ScopeBase parent) {
        super(parent);
    }

    public ScopeGlobal(String scopeName, ScopeBase parent) {
        super(scopeName, parent);
    }

    private final HashMap<String, SymbolFunction> natives = new HashMap<>();

    public void defineNative(String name, PrimitiveType returnType, List<NameAndType> parameters) {
        SymbolFunction symbol = new SymbolFunction(returnType, -1);

        for (NameAndType parameter : parameters) {
            symbol.defineParameter(parameter.Name, parameter.Type.PrimitiveType);
        }

        natives.put(name, symbol);
    }

    @NotNull
    public SymbolFunction getNativeDefinition(String name) {
        if(!natives.containsKey(name)) {
            throw new UnsupportedOperationException("Native \""+name+"\" is not defined!");
        }
        return natives.get(name);
    }
}
