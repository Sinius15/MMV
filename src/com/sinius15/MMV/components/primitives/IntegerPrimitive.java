package com.sinius15.MMV.components.primitives;

import com.sinius15.MMV.components.PrimitiveVariable;
import com.sinius15.MMV.exceptions.PrimitiveException;

/**
 * Created by Sinius15 on 5-2-2015.
 */
public class IntegerPrimitive extends PrimitiveVariable<Integer>{

    public IntegerPrimitive(String name, Integer value) {
        super(name, value);
        if(getValue() == null)
            setValue(new Integer(0));
    }

    @Override
    public void assign(PrimitiveVariable<?> value) {

        if(value.getValue() instanceof Number){
            Number n = (Number) value.getValue();
            setValue(n.intValue());
        }
        if(value.getValue() instanceof Character){
            Character c = (Character) value.getValue();
            setValue((int) c.charValue());
        }

        throw new PrimitiveException("Can not assign "+value.getType().getName()+" to Integer.");
    }

    @Override
    public Integer plus(PrimitiveVariable<?> value) {
        if(value.getValue() instanceof Number){
            Number n = (Number) value.getValue();
            return getValue() + n.intValue();
        }
        if(value.getValue() instanceof Character){
            Character c = (Character) value.getValue();
            return getValue() + c.charValue();
        }

        throw new PrimitiveException("Can not add Integer to "+value.getType().getName());
    }

    @Override
    public Integer minus(PrimitiveVariable<?> value) {
        if(value.getValue() instanceof Number){
            Number n = (Number) value.getValue();
            return getValue() - n.intValue();
        }
        if(value.getValue() instanceof Character){
            Character c = (Character) value.getValue();
            return getValue() - c.charValue();
        }

        throw new PrimitiveException("Can not subtract "+value.getType().getName() + "from Integer");
    }

    @Override
    public Integer star(PrimitiveVariable<?> value) {
        if(value.getValue() instanceof Number){
            Number n = (Number) value.getValue();
            return getValue() * n.intValue();
        }
        if(value.getValue() instanceof Character){
            Character c = (Character) value.getValue();
            return getValue() * c.charValue();
        }

        throw new PrimitiveException("Can not multiply Integer to "+value.getType().getName());
    }

    @Override
    public Integer slash(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Integer and(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Integer or(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Integer xor(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Integer rem(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Integer lShift(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Integer rSignedShift(PrimitiveVariable<?> value) {
        return null;
    }

    @Override
    public Integer rUnsignedShift(PrimitiveVariable<?> value) {
        return null;
    }


}
