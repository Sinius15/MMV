package com.sinius15.MMV;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.stmt.*;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.sinius15.MMV.components.Stackframe;
import com.sinius15.MMV.exceptions.UnsuportedException;
import com.sinius15.MMV.statementExecutors.ExpressionStmtExecutor;

import java.util.List;

/**
 * Give me a Method, and i will execute it.
 */
public class MethodExecutor extends VoidVisitorAdapter<String> {

	private boolean foundStopString = false;

	private Application app;
	private MethodDeclaration method;

	public MethodExecutor(MethodDeclaration method, Application app){
		this.method = method;
		this.app = app;
	}

	public boolean start() {
        app.stack.addStackframe(new Stackframe(method.getName()));

        List<Parameter> parameters = method.getParameters();
        if (parameters != null) {
            throw new IllegalArgumentException("Parameters are not yet supported!");
        }
        method.getBody().accept(this, null);
        if (foundStopString)
            return true;

        app.stack.removeStackframe();
        return foundStopString;
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
		if(tString.contains(Application.STOPSTRING)){
			return true;
		}

		if(t instanceof ExpressionStmt){
            ExpressionStmtExecutor exe = new ExpressionStmtExecutor(app);
			t.accept(exe, null);
		}else if(t instanceof AssertStmt){
            throw new UnsuportedException("I do not support " + t.getClass().getName());
        }else if(t instanceof BlockStmt) {
            throw new UnsuportedException("I do not support " + t.getClass().getName());
        }else if(t instanceof BreakStmt) {
            throw new UnsuportedException("I do not support " + t.getClass().getName());
        }else if(t instanceof ContinueStmt) {
            throw new UnsuportedException("I do not support " + t.getClass().getName());
        }else if(t instanceof DoStmt) {
            throw new UnsuportedException("I do not support " + t.getClass().getName());
        }else if(t instanceof EmptyStmt) {
            throw new UnsuportedException("I do not support " + t.getClass().getName());
        }else if(t instanceof ExplicitConstructorInvocationStmt) {
            throw new UnsuportedException("I do not support " + t.getClass().getName());
        }else if(t instanceof ForeachStmt) {
            throw new UnsuportedException("I do not support " + t.getClass().getName());
        }else if(t instanceof ForStmt) {
            throw new UnsuportedException("I do not support " + t.getClass().getName());
        }else if(t instanceof IfStmt) {
            throw new UnsuportedException("I do not support " + t.getClass().getName());
        }else if(t instanceof LabeledStmt) {
            throw new UnsuportedException("I do not support " + t.getClass().getName());
        }else if(t instanceof ReturnStmt) {
            throw new UnsuportedException("I do not support " + t.getClass().getName());
        }else if(t instanceof SwitchEntryStmt) {
            throw new UnsuportedException("I do not support " + t.getClass().getName());
        }else if(t instanceof SwitchStmt) {
            throw new UnsuportedException("I do not support " + t.getClass().getName());
        }else if(t instanceof SynchronizedStmt) {
            throw new UnsuportedException("I do not support " + t.getClass().getName());
        }else if(t instanceof ThrowStmt) {
            throw new UnsuportedException("I do not support " + t.getClass().getName());
        }else if(t instanceof TryStmt) {
            throw new UnsuportedException("I do not support " + t.getClass().getName());
        }else if(t instanceof TypeDeclarationStmt) {
            throw new UnsuportedException("I do not support " + t.getClass().getName());
        }else if(t instanceof WhileStmt) {
            throw new UnsuportedException("I do not support " + t.getClass().getName());
        }else{
			throw new IllegalArgumentException("I do not support " + tString.getClass().getName());
		}

		return false;
	}



}
