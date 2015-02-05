package com.sinius15.MMV.components;

import java.util.ArrayList;

public class HeapFrame {

	private String name;
	private ArrayList<Variable> variables = new ArrayList<>();

	public HeapFrame(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void addVariable(Variable v){
		variables.add(v);
	}


	public Variable findVariable(String name){
		for(Variable v : variables){
			if(v.getName().equals(name))
				return v;
		}
		return null;
	}

	@Override
	public String toString() {
		String s = "------" + getName() + "------" + System.lineSeparator();
		for(Variable v : variables){
			s += " - " + v.toString() + System.lineSeparator();
		}
		s+="--------------";
		return s;
	}




}
