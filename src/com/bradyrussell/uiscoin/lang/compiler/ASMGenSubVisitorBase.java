/* (C) Brady Russell 2021 */
package com.bradyrussell.uiscoin.lang.compiler;

import com.bradyrussell.uiscoin.lang.compiler.scope.ScopeBase;
import com.bradyrussell.uiscoin.lang.compiler.scope.ScopeGlobal;
import com.bradyrussell.uiscoin.lang.compiler.scope.ScopeLocal;
import com.bradyrussell.uiscoin.lang.generated.UISCBaseVisitor;

public abstract class ASMGenSubVisitorBase<T> extends UISCBaseVisitor<T> {

    ////////////////////////
    ScopeGlobal Global;
    ScopeLocal CurrentLocalScope;

    public ASMGenSubVisitorBase(ScopeGlobal global, ScopeLocal currentLocalScope) {
        Global = global;
        CurrentLocalScope = currentLocalScope;
    }

    ScopeBase getCurrentScope() {
        return CurrentLocalScope == null ? Global : CurrentLocalScope;
    }

/*    void PushLocalScope(String ScopeName) {
        if (CurrentLocalScope == null) {
            CurrentLocalScope = new ScopeLocal(ScopeName, Global);
            Global.Children.add(CurrentLocalScope);
        } else {
            ScopeLocal parent = CurrentLocalScope;
            CurrentLocalScope = new ScopeLocal(ScopeName, parent);
            parent.Children.add(CurrentLocalScope);
        }
    }

    void PushFunctionScope(Type FunctionType, String FunctionName) {
        if (CurrentLocalScope == null) {
            CurrentLocalScope = Global.defineFunction(FunctionName, FunctionType);
        } else {
            CurrentLocalScope = CurrentLocalScope.defineFunction(FunctionName, FunctionType);
        }
    }

    void PopLocalScope() {
        if (CurrentLocalScope.Parent instanceof ScopeLocal) CurrentLocalScope = (ScopeLocal) CurrentLocalScope.Parent;
        CurrentLocalScope = null;
    }*/
    ////////////////////////


}
