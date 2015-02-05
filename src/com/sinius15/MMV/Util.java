package com.sinius15.MMV;

import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.type.PrimitiveType;
import com.github.javaparser.ast.type.ReferenceType;
import com.github.javaparser.ast.type.Type;
import com.sinius15.MMV.components.HeapFrame;
import com.sinius15.MMV.components.PrimitiveVariable;
import com.sinius15.MMV.components.ReferenceVariable;
import com.sinius15.MMV.components.Variable;

public class Util {

	public static Variable createVarFromDeclaration(Application app, FieldDeclaration field) {
		Type t = field.getType();
		String declaration = field.toString();
		if (t instanceof PrimitiveType) {
			declaration = declaration.replace(t.toString(), "").replace(";", "").trim();

			String[] split = declaration.split("=");
			if (split.length == 1)
				return new PrimitiveVariable(split[0].trim(), null);
			else
				return new PrimitiveVariable(split[0].trim(), split[1].trim());
		} else if (t instanceof ReferenceType) {
			ReferenceType ref = (ReferenceType) t;

			//get variable name
			String name = declaration.toString().trim().replaceFirst(ref.toString(), "").replaceAll(";", "").trim();
			String[] split = name.split("=");
			name = split[0].trim();

			ReferenceVariable outRefVar = new ReferenceVariable(name, -1);

			//is variable already initialized?
			if(split.length > 1){
				String value = split[1].trim();
				if(value.startsWith("\"") && value.endsWith("\"")){
					char[] values = value.substring(1, value.length()-1).toCharArray();
					HeapFrame arrayHeap = new HeapFrame("String");
					for(int i =0; i < values.length; i++){
						arrayHeap.addVariable(new PrimitiveVariable("[" + i + "]", values[i]));
					}
					outRefVar.setReferencingTo(app.heap.addHeapFrame(arrayHeap));
				}else if (ref.getArrayCount() == 1) {
					throw new IllegalArgumentException("Ik kan nog niet arrays aan de HEAP toevoegen. Uitgezonderd Strings");
				}else{
					throw new IllegalArgumentException("Ik kan nog niet objecten aan de HEAP toevoegen. Uitgezonderd Strings");
				}
			}
			return outRefVar;
		}
		return null;
	}

}
