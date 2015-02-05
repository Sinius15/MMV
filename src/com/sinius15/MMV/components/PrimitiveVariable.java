package com.sinius15.MMV.components;

public class PrimitiveVariable extends Variable{

	private Object value;

	public PrimitiveVariable(String name, Object value) {
		super(name);
		this.setValue(value);
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return getName() + (getValue() == null ? "" : (" = " + getValue()));
	}

}
