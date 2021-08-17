/* (C) Brady Russell 2021 */
package com.bradyrussell.uiscoin.lang.compiler.type;

import com.bradyrussell.uiscoin.lang.compiler.type.PrimitiveStructOrArrayType;

public class NameAndType {
    public String Name;
    public PrimitiveStructOrArrayType Type;

    public NameAndType(String name, PrimitiveStructOrArrayType type) {
        Name = name;
        Type = type;
    }

}
