package com.sinius15.MMV.components;

public abstract class Variable<T> {

    protected String name;
    protected T value;

	public Variable(String name, T value){
		this.name = name;
        this.value = value;
	}

	public String getName() {
        return name;
    }

    public Class<?> getType(){
        return value.getClass();
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getType().getName() + " " + getName() + (getValue() == null ? "" : (" = " + getValue()));
    }
}
