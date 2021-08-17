/* (C) Brady Russell 2021 */
package com.bradyrussell.uiscoin.lang.compiler.symbol;

import com.bradyrussell.uiscoin.lang.compiler.type.PrimitiveType;

public class SymbolArray extends SymbolBase {
    public int length;

    public SymbolArray(PrimitiveType type, int address, int length) {
        super(type, address);
        this.length = length;
    }
}
