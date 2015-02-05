package com.sinius15.MMV;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class MethodFinder extends VoidVisitorAdapter<Object> {

	private MethodDeclaration foundMethod = null;
	private String name;

	public MethodFinder(String name){
		this.name = name;
	}

	@Override
	public void visit(MethodDeclaration possibleFunc, Object arg) {
		if(possibleFunc.getName().equals(name)){
			foundMethod = possibleFunc;
		}
	}

	public MethodDeclaration getFoundMethod(){
		return foundMethod;
	}
}
