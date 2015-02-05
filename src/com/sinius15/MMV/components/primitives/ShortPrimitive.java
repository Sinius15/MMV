package com.sinius15.MMV.components.primitives;

import com.sinius15.MMV.components.PrimitiveVariable;

/**
 * Created by Sinius15 on 5-2-2015.
 */
public class ShortPrimitive extends PrimitiveVariable<Short> {

    public ShortPrimitive(String name, Short value) {
        super(name, value);
    }

    @Override
    public void assign(PrimitiveVariable<?> value) {

    }

    @Override
    public Short plus(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Short minus(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Short star(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Short slash(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Short and(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Short or(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Short xor(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Short rem(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Short lShift(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Short rSignedShift(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Short rUnsignedShift(PrimitiveVariable<?> value) {
        return null;
    }
}
