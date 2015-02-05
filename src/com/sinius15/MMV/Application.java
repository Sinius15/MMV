package com.sinius15.MMV;


import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.sinius15.MMV.components.Heap;
import com.sinius15.MMV.components.HeapFrame;
import com.sinius15.MMV.components.Stack;
import com.sinius15.MMV.components.Variable;

import java.io.FileInputStream;
import java.util.List;

public class Application {

	private CompilationUnit cu;

	public Stack stack = new Stack();
	public Heap heap = new Heap();

	private MethodDeclaration setupMethod = null;

	public Application(String filename) throws Exception{

		FileInputStream in = new FileInputStream(filename);
		cu = JavaParser.parse(in);

		MethodFinder setupFinder = new MethodFinder("setup");
		setupFinder.visit(cu, null);
		setupMethod = setupFinder.getFoundMethod();
		if(setupMethod == null)
			throw new IllegalArgumentException("could not find setup.");

		addGlobalVariablesToHeap();
	}

	private void addGlobalVariablesToHeap() {
		HeapFrame globalHeapFrame = new HeapFrame("Global");

		TypeDeclaration mainClass = cu.getTypes().get(0);
		List<BodyDeclaration> decs = mainClass.getMembers();
		for(BodyDeclaration declaration : decs){
			if(declaration instanceof FieldDeclaration){
				FieldDeclaration field = (FieldDeclaration) declaration;
				Variable v = Util.createVarFromDeclaration(this, field);
				globalHeapFrame.addVariable(v);
			}
		}
		heap.addHeapFrame(globalHeapFrame);
	}

	public void simulateUntil(String stopString){
		new MethodExecutor(stopString, setupMethod, this).start();
	}

	public MethodDeclaration getMethodDeclarationByName(String name) {
		MethodFinder finder = new MethodFinder(name);
		finder.visit(cu, null);
		return finder.getFoundMethod();
	}

	public void createMemoryModel(){
		System.out.println(stack.toString());
		System.out.println();
		System.out.println(heap.toString());
	}

	public static void main(String[] args) {
		try {
			Application app = new Application("test/testClass.java");
			app.simulateUntil("stopikwilstoppen");
			System.out.println();
			System.out.println();
			System.out.println();
			app.createMemoryModel();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}