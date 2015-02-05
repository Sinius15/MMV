package com.sinius15.MMV.components;

public abstract class Variable {

	private String name;

	public Variable(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public boolean isPrimitive() {
		return this instanceof PrimitiveVariable;
	}

}
