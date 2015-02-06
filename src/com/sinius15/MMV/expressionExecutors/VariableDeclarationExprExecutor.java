package com.sinius15.MMV.expressionExecutors;

import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.sinius15.MMV.Application;
import com.sinius15.MMV.Util;
import com.sinius15.MMV.components.Variable;

public class VariableDeclarationExprExecutor extends VoidVisitorAdapter<String> {

	Application app;

	public VariableDeclarationExprExecutor(Application app){
		this.app = app;
	}

	@Override
	public void visit(VariableDeclarationExpr n, String arg) {
        for(Variable v : Util.createVarFromDecleration(n))
		    app.getTopStackFrame().addVariable(v);

	}

}