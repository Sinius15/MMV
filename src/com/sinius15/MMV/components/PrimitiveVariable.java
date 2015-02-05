package com.sinius15.MMV.components;

public abstract class PrimitiveVariable<T> extends Variable<T>{


    public PrimitiveVariable(String name, T value) {
        super(name, value);
    }

    public void setValue(T value){
        this.value = value;

        boolean b = true;
        char c = '0';
        byte y = 0;
        double d = 0.0;
        float f = 0.0f;
        int i = 0;
        long l = 0;
        short s = 0;

        i = i * c;
    }

    public abstract void assign(PrimitiveVariable<?> value);
    public abstract T plus(PrimitiveVariable<?> value);
    public abstract T minus(PrimitiveVariable<?> value);
    public abstract T star(PrimitiveVariable<?> value);
    public abstract T slash(PrimitiveVariable<?> value);
    public abstract T and(PrimitiveVariable<?> value);
    public abstract T or(PrimitiveVariable<?> value);
    public abstract T xor(PrimitiveVariable<?> value);
    public abstract T rem(PrimitiveVariable<?> value);
    public abstract T lShift(PrimitiveVariable<?> value);
    public abstract T rSignedShift(PrimitiveVariable<?> value);
    public abstract T rUnsignedShift(PrimitiveVariable<?> value);



}
