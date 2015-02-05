package com.sinius15.MMV.components;

import java.util.ArrayList;

public class Stack {

	private ArrayList<Stackframe> stackFrames = new ArrayList<>();

	public void addStackframe(Stackframe s){
		stackFrames.add(s);
	}

	public void removeStackframe(){
		stackFrames.remove(stackFrames.size()-1);
	}

	@Override
	public String toString() {
		String s = "======STACK======" + System.lineSeparator();
		for(Stackframe f : stackFrames){
			s += f.toString();
			s += System.lineSeparator() + System.lineSeparator();
		}
		s += "=================";
		return s;
	}

}
