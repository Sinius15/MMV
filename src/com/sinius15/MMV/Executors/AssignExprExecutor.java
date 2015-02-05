package com.sinius15.MMV.Executors;

import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.sinius15.MMV.Application;
import com.sinius15.MMV.Util;
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

        Variable<?> valueVariable = Util.createVarFromExpression(valExpression);

        if(targetVariable instanceof PrimitiveVariable && valueVariable instanceof PrimitiveVariable){
            PrimitiveVariable<?> primTar = (PrimitiveVariable) targetVariable;
            PrimitiveVariable<?> primVal = (PrimitiveVariable) valueVariable;
            switch (n.getOperator()) {
                case and:
                    throw new IllegalArgumentException("Unknown Operator");
                case assign:
                    primTar.assign(primVal);
                    break;
                case lShift:throw new IllegalArgumentException("Unknown Operator");
                case minus:throw new IllegalArgumentException("Unknown Operator");
                case or:throw new IllegalArgumentException("Unknown Operator");
                case plus:throw new IllegalArgumentException("Unknown Operator");
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

}
