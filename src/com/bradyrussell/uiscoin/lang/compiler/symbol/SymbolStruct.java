/* (C) Brady Russell 2021 */
package com.bradyrussell.uiscoin.lang.compiler.symbol;

import com.bradyrussell.uiscoin.lang.compiler.type.StructDefinition;

public class SymbolStruct extends SymbolBase {
    public StructDefinition struct;
    public SymbolStruct(int address, StructDefinition struct) {
        super(null, address);
        this.struct = struct;
    }
}
