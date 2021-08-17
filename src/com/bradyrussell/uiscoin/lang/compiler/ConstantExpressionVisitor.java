/* (C) Brady Russell 2021 */
package com.bradyrussell.uiscoin.lang.compiler;

import com.bradyrussell.uiscoin.lang.compiler.type.TypedValue;
import com.bradyrussell.uiscoin.lang.generated.UISCBaseVisitor;

public class ConstantExpressionVisitor extends UISCBaseVisitor<TypedValue> {
    @Override
    protected TypedValue defaultResult() {
        return null;
    }


}
