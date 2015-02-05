package com.sinius15.MMV.components;

import java.util.HashMap;

public class Heap {

	private int globalFrameId = -1;

	private int nextId = 0;
	private HashMap<Integer, HeapFrame> heapFrames = new HashMap<>(); //referenceid, heapframe

	/**
	 * returns the reference id to the object.
	 */
	public int addHeapFrame(HeapFrame s){
		heapFrames.put(nextId, s);
		if(s.getName().equals("Global")){
			globalFrameId = nextId;
		}
		nextId++;
		return nextId-1;
	}

	public HeapFrame getHeapFrame(int referenceId){
		return heapFrames.get(referenceId);
	}

	public HeapFrame getGlobalHeapFrame(){
		return heapFrames.get(globalFrameId);
	}

	public void removeHeapframe(int referenceId){
		heapFrames.remove(referenceId);
	}

	@Override
	public String toString() {
		String s = "======HEAP======" + System.lineSeparator();
		for(int id : heapFrames.keySet()){
			s += heapFrames.get(id).toString();
			s += "(" + id + ")";
			s += System.lineSeparator() + System.lineSeparator();
		}
		s += "=================";
		return s;
	}

}
