/* (C) Brady Russell 2021 */
package com.bradyrussell.uiscoin.lang.compiler.scope;

import com.bradyrussell.uiscoin.lang.compiler.ASMUtil;
import com.bradyrussell.uiscoin.lang.compiler.symbol.SymbolFunction;

public class ScopeWithSymbol extends ScopeLocal implements com.bradyrussell.uiscoin.lang.compiler.symbol.Symbol {
    public SymbolFunction Symbol;

    public ScopeWithSymbol(String scopeName, ScopeBase parent, SymbolFunction symbol) {
        super(scopeName, parent);
        Symbol = symbol;
    }

    @Override
    public Integer getSymbolAddress() {
        return Symbol.address;
    }

    @Override
    public String generateGetSymbolASM() {
        return ASMUtil.generateLoadAddress(getSymbolAddress());
    }

    @Override
    public String generateSetSymbolASM() {
        return ASMUtil.generateStoreAddress(getSymbolAddress());
    }
}
