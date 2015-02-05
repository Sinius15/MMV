package com.sinius15.MMV.components.primitives;

import com.sinius15.MMV.components.PrimitiveVariable;

/**
 * Created by Sinius15 on 5-2-2015.
 */
public class FloatPrimitive extends PrimitiveVariable<Float> {

    public FloatPrimitive(String name, Float value) {
        super(name, value);
    }

    @Override
    public void assign(PrimitiveVariable<?> value) {

    }

    @Override
    public Float plus(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Float minus(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Float star(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Float slash(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Float and(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Float or(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Float xor(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Float rem(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Float lShift(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Float rSignedShift(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Float rUnsignedShift(PrimitiveVariable<?> value) {
        return null;
    }
}
