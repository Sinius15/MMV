package com.sinius15.MMV.Executors;

import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.sinius15.MMV.Application;
import com.sinius15.MMV.components.PrimitiveVariable;
import com.sinius15.MMV.components.Stackframe;

public class VariableDeclarationExprExecutor extends VoidVisitorAdapter<String> {

	Application app;
	Stackframe curFrame;

	public VariableDeclarationExprExecutor(Application app, Stackframe curFrame){
		this.app = app;
		this.curFrame = curFrame;
	}

	@Override
	public void visit(VariableDeclarationExpr n, String arg) {
		for(VariableDeclarator d: n.getVars()){
			curFrame.addVariable(new PrimitiveVariable(d.getId().toString(), (d.getInit() == null ? null : d.getInit().toString())));
		}
	}

}