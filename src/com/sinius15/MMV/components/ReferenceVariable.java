package com.sinius15.MMV.components;

import com.sinius15.MMV.Application;

public class ReferenceVariable extends Variable<Integer>{

	public ReferenceVariable(String name, int referenceId) {
		super(name, referenceId);
	}

	public HeapFrame referencingTo(Application app) {
        return app.heap.getHeapFrame(getValue());
    }

	@Override
	public String toString() {
		return getName() +(getValue() == -1 ? "" : (" referencing to " + getValue()));
	}

}
