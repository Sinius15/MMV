package com.sinius15.MMV;


import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.sinius15.MMV.components.*;

import java.io.FileInputStream;
import java.util.List;

public class Application {

    public static final String STOPSTRING = "stopikwilstoppen";

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
				List<Variable> newVars = Util.createVarFromDeclaration(field);
                for(Variable newVar : newVars) {
                    globalHeapFrame.addVariable(newVar);
                }
			}
		}
		heap.addHeapFrame(globalHeapFrame);
	}

	public void simulateUntil(){
		new MethodExecutor(setupMethod, this).start();
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
			app.simulateUntil();
			System.out.println();
			System.out.println();
			System.out.println();
			app.createMemoryModel();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    public Stackframe getTopStackFrame() {
        return stack.getTopStackFrame();
    }
}
