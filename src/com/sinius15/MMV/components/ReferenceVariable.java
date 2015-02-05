package com.sinius15.MMV.components;

import com.sinius15.MMV.Application;

public class ReferenceVariable extends Variable{

	//-1 == null
	private int referencingTo;

	public ReferenceVariable(String name, int referenceId) {
		super(name);
		this.referencingTo = referenceId;
	}

	public HeapFrame referencingTo(Application app){
		return app.heap.getHeapFrame(referencingTo);
	}

	public void setReferencingTo(int referenceId){
		this.referencingTo = referenceId;
	}

	@Override
	public String toString() {
		return getName() +(referencingTo == -1 ? "" : (" refering to " + referencingTo));
	}

}
