package com.sinius15.MMV.Executors;

import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.IntegerLiteralExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.sinius15.MMV.Application;
import com.sinius15.MMV.components.PrimitiveVariable;
import com.sinius15.MMV.components.Stackframe;
import com.sinius15.MMV.components.Variable;

public class AssignExprExecutor extends VoidVisitorAdapter<String> {

	Application app;
	Stackframe curFrame;

	public AssignExprExecutor(Application app, Stackframe curFrame){
		this.app = app;
		this.curFrame = curFrame;
	}

	@Override
	public void visit(AssignExpr n, String arg) {
		//target
		Expression target = n.getTarget();
		String targetName;
		if(target instanceof NameExpr){
			targetName = ((NameExpr) target).getName();
		}else{
			throw new IllegalArgumentException("I do not support anything but NameExpressions for the target");
		}
		Variable targetVariable = curFrame.findVariable(targetName);
		if(targetVariable == null){  //it is probably a global variable
			targetVariable = app.heap.getGlobalHeapFrame().findVariable(targetName);
		}
		if(targetVariable == null)
			throw new IllegalArgumentException("Could not find variable " + targetName);

		//value
		Expression valExpression = n.getValue();
		String value = null;
		if(valExpression instanceof IntegerLiteralExpr){
			IntegerLiteralExpr integer = (IntegerLiteralExpr) valExpression;
			value = integer.getValue();
		}else{
			throw new IllegalArgumentException("I do not support anything but IntegerLiteralExpr for the value. You are trying to use "+ valExpression.getClass().getName());
		}

		switch (n.getOperator()) {
			case and:
				throw new IllegalArgumentException("Unknown Operator");
			case assign:
				if(targetVariable.isPrimitive()){
					((PrimitiveVariable) targetVariable).setValue(value);
				}
				break;
			case lShift:throw new IllegalArgumentException("Unknown Operator");
			case minus:throw new IllegalArgumentException("Unknown Operator");
			case or:throw new IllegalArgumentException("Unknown Operator");
			case plus:
				throw new IllegalArgumentException("Unknown Operator");
			case rSignedShift:throw new IllegalArgumentException("Unknown Operator");
			case rUnsignedShift:throw new IllegalArgumentException("Unknown Operator");
			case rem:throw new IllegalArgumentException("Unknown Operator");
			case slash:throw new IllegalArgumentException("Unknown Operator");
			case star:throw new IllegalArgumentException("Unknown Operator");
			case xor:throw new IllegalArgumentException("Unknown Operator");
			default:
				throw new IllegalArgumentException("Unknown Operator");
		}
	}

}
