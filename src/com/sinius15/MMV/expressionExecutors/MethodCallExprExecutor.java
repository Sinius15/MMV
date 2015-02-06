package com.sinius15.MMV.expressionExecutors;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.visitor.GenericVisitorAdapter;
import com.sinius15.MMV.Application;
import com.sinius15.MMV.MethodExecutor;

public class MethodCallExprExecutor extends GenericVisitorAdapter<Boolean, String> {

	Application app;

	public MethodCallExprExecutor(Application app){
		this.app = app;
	}

	public Boolean visit(MethodCallExpr method, String arg) {
		method.getName();
		MethodDeclaration decl = app.getMethodDeclarationByName(method.getName());
		if(decl == null)
			throw new IllegalArgumentException("Could not find method " + method.getName());

		MethodExecutor exe = new MethodExecutor(decl, app);
		return exe.start();
	}

}