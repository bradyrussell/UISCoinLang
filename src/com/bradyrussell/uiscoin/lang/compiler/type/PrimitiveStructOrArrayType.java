/* (C) Brady Russell 2021 */
package com.bradyrussell.uiscoin.lang.compiler.type;

import java.util.Objects;

import com.bradyrussell.uiscoin.lang.compiler.scope.ScopeBase;

public class PrimitiveStructOrArrayType {
    public PrimitiveType PrimitiveType;
    public int ArrayLength = -1;
    public String StructName = null;

    public boolean isArray(){
        return ArrayLength >= 0;
    }

    public boolean isStruct() {
        return StructName != null;
    }

    public boolean isPrimitive() {
        return !isArray() && !isStruct();
    }

    public boolean isStructArray() {
        return isArray() && isStruct();
    }

    public PrimitiveStructOrArrayType(PrimitiveType type) {
        PrimitiveType = type;
    }

    public PrimitiveStructOrArrayType(PrimitiveType type, int arrayLength) {
        PrimitiveType = type;
        ArrayLength = arrayLength;
    }

    public PrimitiveStructOrArrayType(String structName) {
        StructName = structName;
    }

    public PrimitiveStructOrArrayType(String structName, int arrayLength) {
        ArrayLength = arrayLength;
        StructName = structName;
    }

    public int getSize(ScopeBase CurrentScope) {
        if(isPrimitive()) return PrimitiveType.getSize();
        if(isStructArray()) return CurrentScope.findStructDefinition(StructName).getSize() * ArrayLength;
        if(isStruct())return CurrentScope.findStructDefinition(StructName).getSize();
        if(isArray()) return PrimitiveType.getSize() * ArrayLength;
        throw new UnsupportedOperationException("How did you get here?");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrimitiveStructOrArrayType that = (PrimitiveStructOrArrayType) o;

        if(that.isArray() != this.isArray() || that.isStruct() != this.isStruct()) return false;
        if(that.isArray() && this.isArray() && that.isStruct() && this.isStruct()) return this.StructName.equals(that.StructName) && that.ArrayLength == this.ArrayLength;
        if(that.isStruct() && this.isStruct()) return this.StructName.equals(that.StructName);
        if(that.isArray() && this.isArray()) return this.PrimitiveType.equals(that.PrimitiveType) && that.ArrayLength == this.ArrayLength;
        return that.PrimitiveType.equals(this.PrimitiveType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(PrimitiveType, ArrayLength, StructName);
    }

    @Override
    public String toString() {
        String type = isStructArray() ? (StructName+"Array["+ArrayLength+"]") : isStruct() ? StructName : isArray() ? (PrimitiveType +"Array["+ArrayLength+"]") : PrimitiveType.toString();

        return "PrimitiveStructOrArrayType{"+ type +"}";
    }
}
