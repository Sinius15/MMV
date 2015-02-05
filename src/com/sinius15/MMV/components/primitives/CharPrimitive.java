package com.sinius15.MMV.components.primitives;

import com.sinius15.MMV.components.PrimitiveVariable;

/**
 * Created by Sinius15 on 5-2-2015.
 */
public class CharPrimitive extends PrimitiveVariable<Character> {

    public CharPrimitive(String name, Character value) {
        super(name, value);
    }

    @Override
    public void assign(PrimitiveVariable<?> value) {

    }

    @Override
    public Character plus(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Character minus(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Character star(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Character slash(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Character and(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Character or(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Character xor(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Character rem(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Character lShift(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Character rSignedShift(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Character rUnsignedShift(PrimitiveVariable<?> value) {
        return null;
    }
}
