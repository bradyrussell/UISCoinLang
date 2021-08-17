/* (C) Brady Russell 2021 */
package com.bradyrussell.uiscoin.lang.compiler.scope;

public class ScopeGlobal extends ScopeBase {
    public ScopeGlobal(ScopeBase parent) {
        super(parent);
    }

    public ScopeGlobal(String scopeName, ScopeBase parent) {
        super(scopeName, parent);
    }
}
