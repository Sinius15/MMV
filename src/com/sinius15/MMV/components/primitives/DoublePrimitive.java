package com.sinius15.MMV.components.primitives;

import com.sinius15.MMV.components.PrimitiveVariable;

/**
 * Created by Sinius15 on 5-2-2015.
 */
public class DoublePrimitive extends PrimitiveVariable<Double> {

    public DoublePrimitive(String name, Double value) {
        super(name, value);
    }

    @Override
    public void assign(PrimitiveVariable<?> value) {

    }

    @Override
    public Double plus(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Double minus(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Double star(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Double slash(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Double and(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Double or(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Double xor(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Double rem(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Double lShift(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Double rSignedShift(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Double rUnsignedShift(PrimitiveVariable<?> value) {
        return null;
    }
}
