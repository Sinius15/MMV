package com.sinius15.MMV.statementExecutors;

import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.sinius15.MMV.Application;
import com.sinius15.MMV.expressionExecutors.AssignExprExecutor;
import com.sinius15.MMV.expressionExecutors.MethodCallExprExecutor;
import com.sinius15.MMV.expressionExecutors.VariableDeclarationExprExecutor;

/**
 * Created by Sinius15 on 6-2-2015.
 */
public class ExpressionStmtExecutor extends VoidVisitorAdapter<String> {

    private final Application app;
    private boolean foundStopString;

    public ExpressionStmtExecutor(Application app){
        this.app = app;
        this.foundStopString = false;
    }

    @Override
    public void visit(ExpressionStmt t, String arg) {
        if(foundStopString)
            return;
        Expression e = t.getExpression();

        System.out.println("now executing line: \t\t" + e.toString() + "  \t\t" + e.getClass().getName());
        if(e instanceof AssignExpr){
            AssignExprExecutor ass = new AssignExprExecutor(app, app.getTopStackFrame());
            e.accept(ass, null);
        }else if(e instanceof VariableDeclarationExpr){
            VariableDeclarationExprExecutor ass = new VariableDeclarationExprExecutor(app);
            e.accept(ass,  null);
        }else if(e instanceof MethodCallExpr){
            MethodCallExprExecutor ass = new MethodCallExprExecutor(app);
            if(e.accept(ass,  null)){
                foundStopString = true;
            }
        }else{
            throw new IllegalArgumentException("I do not support " + e.getClass().getName());
        }
    }

}
