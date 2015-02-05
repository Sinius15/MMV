package com.sinius15.MMV.Executors;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.visitor.GenericVisitorAdapter;
import com.sinius15.MMV.Application;
import com.sinius15.MMV.MethodExecutor;

public class MethodCallExprExecutor extends GenericVisitorAdapter<Boolean, String> {

	Application app;
	String stopString;

	public MethodCallExprExecutor(Application app, String stopString){
		this.app = app;
		this.stopString = stopString;
	}

	public Boolean visit(MethodCallExpr method, String arg) {
		method.getName();
		MethodDeclaration decl = app.getMethodDeclarationByName(method.getName());
		if(decl == null)
			throw new IllegalArgumentException("Could not find method " + method.getName());

		MethodExecutor exe = new MethodExecutor(stopString, decl, app);
		return exe.start();
	}

}