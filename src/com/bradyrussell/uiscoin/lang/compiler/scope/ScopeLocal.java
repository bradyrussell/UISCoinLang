/* (C) Brady Russell 2021 */
package com.bradyrussell.uiscoin.lang.compiler.scope;

public class ScopeLocal extends ScopeBase {
    public ScopeLocal(ScopeBase parent) {
        super(parent);
    }

    public ScopeLocal(String scopeName, ScopeBase parent) {
        super(scopeName, parent);
    }
}
