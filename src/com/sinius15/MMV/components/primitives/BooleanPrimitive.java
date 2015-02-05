package com.sinius15.MMV.components.primitives;

import com.sinius15.MMV.components.PrimitiveVariable;

/**
 * Created by Sinius15 on 5-2-2015.
 */
public class BooleanPrimitive extends PrimitiveVariable<Boolean> {

    public BooleanPrimitive(String name, Boolean value) {
        super(name, value);
    }

    @Override
    public void assign(PrimitiveVariable<?> value) {

    }

    @Override
    public Boolean plus(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Boolean minus(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Boolean star(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Boolean slash(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Boolean and(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Boolean or(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Boolean xor(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Boolean rem(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Boolean lShift(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Boolean rSignedShift(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Boolean rUnsignedShift(PrimitiveVariable<?> value) {
        return null;
    }
}
