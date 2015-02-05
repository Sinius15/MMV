package com.sinius15.MMV.components.primitives;

import com.sinius15.MMV.components.PrimitiveVariable;

/**
 * Created by Sinius15 on 5-2-2015.
 */
public class BytePrimitive extends PrimitiveVariable<Byte>{

    public BytePrimitive(String name, Byte value) {
        super(name, value);
    }

    @Override
    public void assign(PrimitiveVariable<?> value) {

    }

    @Override
    public Byte plus(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Byte minus(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Byte star(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Byte slash(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Byte and(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Byte or(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Byte xor(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Byte rem(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Byte lShift(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Byte rSignedShift(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Byte rUnsignedShift(PrimitiveVariable<?> value) {
        return null;
    }
}
