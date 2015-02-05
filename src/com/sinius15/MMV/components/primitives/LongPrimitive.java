package com.sinius15.MMV.components.primitives;

import com.sinius15.MMV.components.PrimitiveVariable;

/**
 * Created by Sinius15 on 5-2-2015.
 */
public class LongPrimitive extends PrimitiveVariable<Long> {

    public LongPrimitive(String name, Long value) {
        super(name, value);
    }

    @Override
    public void assign(PrimitiveVariable<?> value) {

    }

    @Override
    public Long plus(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Long minus(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Long star(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Long slash(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Long and(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Long or(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Long xor(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Long rem(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Long lShift(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Long rSignedShift(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Long rUnsignedShift(PrimitiveVariable<?> value) {
        return null;
    }
}
