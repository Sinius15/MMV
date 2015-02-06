package com.sinius15.MMV;

import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.type.PrimitiveType;
import com.github.javaparser.ast.type.Type;
import com.sinius15.MMV.components.PrimitiveVariable;
import com.sinius15.MMV.components.Variable;
import com.sinius15.MMV.components.primitives.*;
import com.sinius15.MMV.exceptions.UnsuportedException;
import com.sinius15.MMV.expressionExecutors.BinaryExprExecutor;

import java.util.ArrayList;
import java.util.List;

public class Util {

	public static List<Variable> createVarFromDeclaration(FieldDeclaration field) {
        return createVariables(field.getType(), field.getVariables());
	}

    public static List<Variable> createVarFromDecleration(VariableDeclarationExpr field) {
        return createVariables(field.getType(), field.getVars());
    }

    public static Variable<?> createVarFromExpression(Expression e){
        System.out.println(e.getClass().getName());
        return null;
    }

    private static List<Variable> createVariables(Type t, List<VariableDeclarator> lst){
        List<Variable> out = new ArrayList<>();

        if (t instanceof PrimitiveType) {
            PrimitiveType primitiveType =  (PrimitiveType)t;

            for(VariableDeclarator d : lst){
                if(d.getInit() instanceof BinaryExpr){
                    BinaryExprExecutor exe = new BinaryExprExecutor();
                    String value = d.getInit().accept(exe, null);
                    out.add(createPrimitive(d.getId().getName(), primitiveType, value));
                }else if(d.getInit() instanceof LiteralExpr){
                    out.add(createPrimitive(d.getId().getName(), primitiveType, d.getInit().toString()));
                }else if(d.getInit() == null){
                    out.add(createPrimitive(d.getId().getName(), primitiveType, null));
                }else{
                    throw new UnsuportedException("Not yet supported " + d.getInit().getClass().toString());
                }

            }

        } else {
            throw new UnsuportedException("Only support primitive types");
        }
        return out;
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
