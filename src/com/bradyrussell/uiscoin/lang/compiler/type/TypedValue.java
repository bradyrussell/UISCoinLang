/* (C) Brady Russell 2021 */
package com.bradyrussell.uiscoin.lang.compiler.type;

import java.util.ArrayList;
import java.util.Arrays;

import com.bradyrussell.uiscoin.lang.compiler.symbol.Symbol;

public class TypedValue implements Symbol {
    public boolean bIsArray;
    public boolean bIsPointer;
    public ArrayList<TypedValue> ArrayElements;

    public PrimitiveType type;
    public  byte byteValue;
    public  int intValue;
    public  long longValue;
    public  float floatValue;
    public  int pointerValue;

    public TypedValue(byte byteValue) {
        this.type = PrimitiveType.Byte;
        this.byteValue = byteValue;
    }

    public TypedValue(int intValue) {
        this.type = PrimitiveType.Int32;
        this.intValue = intValue;
    }

    public TypedValue(long longValue) {
        this.type = PrimitiveType.Int64;
        this.longValue = longValue;
    }

    public TypedValue(float floatValue) {
        this.type = PrimitiveType.Float;
        this.floatValue = floatValue;
    }

    public TypedValue(TypedValue... arrayElementsVararg) {
        bIsArray = true;
        ArrayList<TypedValue> arrayElements = new ArrayList<>(Arrays.asList(arrayElementsVararg));
        this.type = arrayElements.size() == 0 ? PrimitiveType.Void : arrayElements.get(0).type;
        ArrayElements = arrayElements;
    }

    public TypedValue(ArrayList<TypedValue> arrayElements) {
        bIsArray = true;
        this.type = arrayElements.size() == 0 ? PrimitiveType.Void : arrayElements.get(0).type;
        ArrayElements = arrayElements;
    }

    public TypedValue(PrimitiveType type, long Value) {
        this.type = type;
        this.byteValue = (byte) Value;
        this.intValue = (int) Value;
        this.longValue = Value;
        this.pointerValue = (int) Value;
    }

    public TypedValue(PrimitiveType type, long Value, boolean bIsPointer) {
        this.type = type;
        this.bIsPointer = bIsPointer;
        if(bIsPointer) {
            this.pointerValue = (int) Value;
        } else {
            this.byteValue = (byte) Value;
            this.intValue = (int) Value;
            this.longValue = Value;
        }
    }

    public TypedValue(String NumberString) {
        try {
            byteValue = Byte.parseByte(NumberString);
            type = PrimitiveType.Byte;
        } catch (Exception e) {
            try {
                intValue = Integer.parseInt(NumberString);
                type =  PrimitiveType.Int32;
            } catch (Exception e2) {
                try {
                    longValue = Long.parseLong(NumberString);
                    type =  PrimitiveType.Int64;
                } catch (Exception e3) {
                    try {
                        floatValue = Float.parseFloat(NumberString);
                        type =  PrimitiveType.Float;
                    } catch (Exception e4) {
                        System.out.println("Cannot deduce type of number: "+NumberString);
                        type =  null;
                    }
                }
            }
        }
    }

    public TypedValue(boolean bIsArray) {
        this.bIsArray = bIsArray;
        ArrayElements = new ArrayList<>();
    }

    @Override
    public String toString() {
        switch (type){

            case Void -> {
                return "";
            }
            case Byte -> {
                return "[" +String.valueOf(byteValue)+"]";
            }
            case Int32 -> {
                return String.valueOf(intValue);
            }
            case Int64 -> {
                return String.valueOf(longValue);
            }
            case Float -> {
                return String.valueOf(floatValue);
            }
            case VoidPointer, FloatPointer, Int64Pointer, Int32Pointer, BytePointer -> {
                return String.valueOf(pointerValue);
            }
        }
        return null;
    }

    @Override
    public Integer getSymbolAddress() {
        return null;
    }

    @Override
    public String generateGetSymbolASM() {
        return "push "+toString();
    }

    @Override
    public String generateSetSymbolASM() {
        throw new UnsupportedOperationException("Cannot set a constant!");
    }
}
