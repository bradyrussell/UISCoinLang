/* (C) Brady Russell 2021 */
package com.bradyrussell.uiscoin.lang.compiler.symbol;

public interface Symbol {
    Integer getSymbolAddress();

    String generateGetSymbolASM();
    String generateSetSymbolASM();
}
