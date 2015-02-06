package com.sinius15.MMV.expressionExecutors;

import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.visitor.GenericVisitorAdapter;

/**
 * Created by Sinius15 on 6-2-2015.
 */
public class BinaryExprExecutor extends GenericVisitorAdapter<String, String> {


    public BinaryExprExecutor(){

    }

    @Override
    public String visit(BinaryExpr n, String arg) {

        System.out.println(n.getLeft().getClass());

        return null;
    }
}