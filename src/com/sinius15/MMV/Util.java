package com.sinius15.MMV;

import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.type.PrimitiveType;
import com.github.javaparser.ast.type.Type;
import com.sinius15.MMV.components.PrimitiveVariable;
import com.sinius15.MMV.components.Variable;
import com.sinius15.MMV.components.primitives.*;
import com.sinius15.MMV.exceptions.UnsuportedException;

import java.util.ArrayList;
import java.util.List;

public class Util {

	public static List<Variable> createVarFromDeclaration(Application app, FieldDeclaration field) {
        List<Variable> out = new ArrayList<>();

		Type t = field.getType();

		if (t instanceof PrimitiveType) {
            PrimitiveType primitiveType =  (PrimitiveType)t;

            for(VariableDeclarator d : field.getVariables()){
                out.add(createPrimitive(d.getId().getName(), primitiveType, d.getInit() == null ? null : d.getInit().toString()));
            }

		} else {
            throw new UnsuportedException("Only support primitive types");
		}
		return out;
	}

    public static Variable<?> createVarFromExpression(Expression e){
        System.out.println(e.getClass().getName());

        return null;
    }

    private static PrimitiveVariable<?> createPrimitive(String name, PrimitiveType var, String init) {

        switch (var.getType()) {
            case Boolean:
                return new BooleanPrimitive(name, init == null ? false : Boolean.valueOf(init));
            case Char:
                return new CharPrimitive(name, (init == null) ? 0 : init.charAt(0));
            case Byte:
                return new BytePrimitive(name, (init == null) ? (byte) 0 : Byte.valueOf(init));
            case Short:
                return new ShortPrimitive(name, (init == null) ? (short) 0 : Short.valueOf(init));
            case Int:
                return new IntegerPrimitive(name, (init == null) ? 0 : Integer.valueOf(init));
            case Long:
                return new LongPrimitive(name, (init == null) ? 0l : Long.valueOf(init));
            case Float:
                return new FloatPrimitive(name, (init == null) ? 0f : Float.valueOf(init));
            case Double:
                return new DoublePrimitive(name, (init == null) ? .0 : Double.valueOf(init));
        }
        return null; //impossible.
    }

}
