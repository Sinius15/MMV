package com.sinius15.MMV;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.DoStmt;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.sinius15.MMV.Executors.AssignExprExecutor;
import com.sinius15.MMV.Executors.MethodCallExprExecutor;
import com.sinius15.MMV.Executors.VariableDeclarationExprExecutor;
import com.sinius15.MMV.components.Stackframe;

import java.util.List;

public class MethodExecutor extends VoidVisitorAdapter<String> {

	private boolean foundStopString = false;

	private Application app;
	private MethodDeclaration method;
	private String stopString;

	private Stackframe curFrame;

	public MethodExecutor(String stopString, MethodDeclaration method, Application app){

		this.stopString = stopString;
		this.method = method;
		this.app = app;

	}

	public boolean start(){
		curFrame = new Stackframe(method.getName());
		app.stack.addStackframe(curFrame);

		List<Parameter> parameters = method.getParameters();
		if(parameters != null){	//this function has parameters
			throw new IllegalArgumentException("Parameters are not yet supported!");
		}
		method.getBody().accept(this, null);
		if(foundStopString)
			return true;

		app.stack.removeStackframe();
		return foundStopString;
	}

	@Override
	public void visit(DoStmt n, String arg) {
		System.out.println(n);
	}

	@Override
	public void visit(BlockStmt n, String arg) {
		if(foundStopString)
			return;
		for(Statement t : n.getStmts())
			if(visitStatement(t)){
				foundStopString = true;
				return;
			}
	}

	public boolean visitStatement(Statement t){
		String tString = t.toString();
		if(tString.contains(stopString)){
			return true;
		}

		if(t instanceof ExpressionStmt){
			t.accept(this, null);
		}else{
			throw new IllegalArgumentException("I do not support " + tString.getClass().getName());
		}

		return false;
	}

	/**
	 * elke Regel code wordt hier gehandeld.
	 */
	@Override
	public void visit(ExpressionStmt t, String arg) {
		if(foundStopString)
			return;
		Expression e = t.getExpression();
		//System.out.println(e.toString() + "  \t\t" + e.getClass().getName());
		if(e instanceof AssignExpr){
			AssignExprExecutor ass = new AssignExprExecutor(app, curFrame);
			e.accept(ass, null);
		}else if(e instanceof VariableDeclarationExpr){
			VariableDeclarationExprExecutor ass = new VariableDeclarationExprExecutor(app, curFrame);
			e.accept(ass,  null);
		}else if(e instanceof MethodCallExpr){
			MethodCallExprExecutor ass = new MethodCallExprExecutor(app, stopString);
			if(e.accept(ass,  null)){
				foundStopString = true;
			}
		}else{
			throw new IllegalArgumentException("I do not support " + e.getClass().getName());
		}
	}

}
