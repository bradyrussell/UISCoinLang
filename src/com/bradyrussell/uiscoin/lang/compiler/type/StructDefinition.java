/* (C) Brady Russell 2021 */
package com.bradyrussell.uiscoin.lang.compiler.type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.bradyrussell.uiscoin.lang.compiler.ASMUtil;
import com.bradyrussell.uiscoin.lang.compiler.scope.ScopeBase;

public class StructDefinition {
    private HashMap<String, PrimitiveStructOrArrayType> structFields;
    private ArrayList<String> structFieldOrder;

    private ScopeBase parentScope;

    public StructDefinition(ScopeBase ParentScope, List<NameAndType> Fields) {
        structFields = new HashMap<>();
        structFieldOrder = new ArrayList<>();
        parentScope = ParentScope;

        for (NameAndType field : Fields) {
            if(field.Type.isStruct()) {
                if (!defineStructField(field.Name, field.Type.StructName)) throw new UnsupportedOperationException("Struct struct field redefinition: " + field.Name);
            } else {
                if (!defineField(field.Name, field.Type)) throw new UnsupportedOperationException("Struct field redefinition: " + field.Name);
            }
        }
    }

    public int getSize(){
        int size = 0;

        for (String s : structFields.keySet()) {
            size += getFieldSize(s);
        }

        return size;
    }

    public int getFieldByteIndex(String FieldName){
        int index = 0;
        for (String structField : structFieldOrder) {
            if(structField.equals(FieldName)) return index;
            index += getFieldSize(structField);
        }
        return -1;
    }

    public int getFieldSize(String FieldName){
        PrimitiveStructOrArrayType value = structFields.get(FieldName);

        if(value.isArray()) {
            return value.ArrayLength * value.PrimitiveType.getSize();
        } else if(value.isStruct()) {
            StructDefinition structDefinition = parentScope.findStructDefinition(value.StructName);

            if(structDefinition == null){
                throw new UnsupportedOperationException("Could not find the struct "+value.StructName+" in the current scope.");
            }

            return value.isArray() ? structDefinition.getSize() * value.ArrayLength : structDefinition.getSize();
        } else {
            return value.PrimitiveType.getSize();
        }

    }

    public boolean defineField(String FieldName, PrimitiveStructOrArrayType FieldType) {
        if(structFields.containsKey(FieldName)) return false;

        structFields.put(FieldName,FieldType);
        structFieldOrder.add(FieldName);

        return true;
    }

    public boolean defineStructField(String FieldName, String StructType) {
        if(structFields.containsKey(FieldName)) return false;

        structFields.put(FieldName,new PrimitiveStructOrArrayType(StructType));
        structFieldOrder.add(FieldName);

        return true;
    }

    public ArrayList<PrimitiveStructOrArrayType> getOrderedTypes(){
        ArrayList<PrimitiveStructOrArrayType> types = new ArrayList<>();
        for (String structField : structFieldOrder) {
            types.add(getFieldType(structField));
        }
        return types;
    }

    public PrimitiveStructOrArrayType getFieldType(String FieldName){
        return structFields.get(FieldName);
    }

    // expects int32 Struct address to be the top stack element
    public String generateFieldGetterASM(String FieldName){
        return ASMUtil.generatePushNumberLiteralCast(getFieldByteIndex(FieldName), PrimitiveType.Int32)+ASMUtil.generatePushNumberLiteralCast(getFieldSize(FieldName), PrimitiveType.Int32)+" get ";
    }

    // expects [Data][int32 Struct Address] on stack
    public String generateFieldSetterASM(String FieldName){
        return ASMUtil.generateComment(FieldName) +ASMUtil.generateComment("Field index: "+getFieldByteIndex(FieldName))+ASMUtil.generatePushNumberLiteralCast(getFieldByteIndex(FieldName), PrimitiveType.Int32)+ASMUtil.generateComment("Field size: "+getFieldSize(FieldName)) +ASMUtil.generatePushNumberLiteralCast(getFieldSize(FieldName), PrimitiveType.Int32)+" set ";
    }

    // push this struct zeroed onto the stack
    public String generateAllocatorASM(){
        return ASMUtil.generatePushNumberLiteralCast(getSize(), PrimitiveType.Int32)+" alloc ";
    }

    @Override
    public String toString() {
        return "StructDefinition{" +
                "structFields=" + structFields +
                ", structFieldOrder=" + structFieldOrder +
                ", parentScope=" + parentScope +
                '}';
    }
}
