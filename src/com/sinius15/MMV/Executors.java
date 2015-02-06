package com.sinius15.MMV;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.TypeParameter;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.comments.BlockComment;
import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.ast.comments.LineComment;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.stmt.*;
import com.github.javaparser.ast.type.*;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.sinius15.MMV.components.Variable;
import com.sinius15.MMV.exceptions.UnsuportedException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sinius15 on 6-2-2015.
 */
public class Executors implements GenericVisitor<Object[], Object[]> {

    ArrayList<ClassOrInterfaceDeclaration> classes = new ArrayList<>();

    @Override
    public Object[] visit(CompilationUnit n, Object[] arg) {

        System.out.println(n.getClass().getName());
            if(n.getPackage() != null)
            n.getPackage().accept(this, null);
        if(n.getImports() != null)
            for(ImportDeclaration importDeclaration : n.getImports()){
                importDeclaration.accept(this, null);
            }
        if(n.getTypes() != null)
            for(TypeDeclaration type : n.getTypes()){
                type.accept(this, null);
            }
        return new Object[0];
    }

    @Override
    public Object[] visit(PackageDeclaration n, Object[] arg) {
        System.out.println(n.getClass().getName());
        return new Object[0];
    }

    @Override
    public Object[] visit(ImportDeclaration n, Object[] arg) {
        System.out.println(n.getClass().getName());
        return new Object[0];
    }

    @Override
    public Object[] visit(TypeParameter n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(LineComment n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(BlockComment n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(ClassOrInterfaceDeclaration classDecl, Object[] arg) {
        System.out.println(classDecl.getClass().getName());
        if(classDecl.isInterface())
            throw new UnsuportedException("I do not support interfaces");

        classes.add(classDecl);

        if(classDecl.getExtends() != null)
            for(ClassOrInterfaceType coit : classDecl.getExtends()){
                coit.accept(this, null);
            }
        if(classDecl.getImplements() != null){
            for(ClassOrInterfaceType coit : classDecl.getImplements()){
                coit.accept(this, null);
            }
        }
        if(classDecl.getTypeParameters() != null)
            for(TypeParameter t : classDecl.getTypeParameters()) {
                t.accept(this, null);
            }
        if(classDecl.getMembers() != null)
            for(BodyDeclaration declaration: classDecl.getMembers()){
                declaration.accept(this, null);
            }
        return new Object[0];
    }

    @Override
    public Object[] visit(EnumDeclaration n, Object[] arg) {
        System.out.println(n.getClass().getName());
        throw new UnsuportedException("I do not support Enums.");
    }

    @Override
    public Object[] visit(EmptyTypeDeclaration n, Object[] arg) {
        System.out.println(n.getClass().getName());
        return new Object[0];
    }

    @Override
    public Object[] visit(EnumConstantDeclaration n, Object[] arg) {
        System.out.println(n.getClass().getName());
        return new Object[0];
    }

    @Override
    public Object[] visit(AnnotationDeclaration n, Object[] arg) {
        System.out.println(n.getClass().getName());
        return new Object[0];
    }

    @Override
    public Object[] visit(AnnotationMemberDeclaration n, Object[] arg) {
        System.out.println(n.getClass().getName());
        return new Object[0];
    }

    @Override
    public Object[] visit(FieldDeclaration n, Object[] arg) {
        List<Variable> vars = Util.createVarFromDeclaration(n);
        return new Object[0];
    }

    @Override
    public Object[] visit(VariableDeclarator n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(VariableDeclaratorId n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(ConstructorDeclaration n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(MethodDeclaration n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(Parameter n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(MultiTypeParameter n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(EmptyMemberDeclaration n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(InitializerDeclaration n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(JavadocComment n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(ClassOrInterfaceType n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(PrimitiveType n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(ReferenceType n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(VoidType n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(WildcardType n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(ArrayAccessExpr n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(ArrayCreationExpr n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(ArrayInitializerExpr n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(AssignExpr n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(BinaryExpr n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(CastExpr n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(ClassExpr n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(ConditionalExpr n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(EnclosedExpr n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(FieldAccessExpr n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(InstanceOfExpr n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(StringLiteralExpr n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(IntegerLiteralExpr n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(LongLiteralExpr n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(IntegerLiteralMinValueExpr n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(LongLiteralMinValueExpr n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(CharLiteralExpr n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(DoubleLiteralExpr n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(BooleanLiteralExpr n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(NullLiteralExpr n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(MethodCallExpr n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(NameExpr n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(ObjectCreationExpr n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(QualifiedNameExpr n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(ThisExpr n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(SuperExpr n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(UnaryExpr n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(VariableDeclarationExpr n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(MarkerAnnotationExpr n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(SingleMemberAnnotationExpr n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(NormalAnnotationExpr n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(MemberValuePair n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(ExplicitConstructorInvocationStmt n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(TypeDeclarationStmt n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(AssertStmt n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(BlockStmt n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(LabeledStmt n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(EmptyStmt n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(ExpressionStmt n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(SwitchStmt n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(SwitchEntryStmt n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(BreakStmt n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(ReturnStmt n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(IfStmt n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(WhileStmt n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(ContinueStmt n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(DoStmt n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(ForeachStmt n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(ForStmt n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(ThrowStmt n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(SynchronizedStmt n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(TryStmt n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(CatchClause n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(LambdaExpr n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(MethodReferenceExpr n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }

    @Override
    public Object[] visit(TypeExpr n, Object[] arg) {
        System.out.println(n.getClass().getName());return new Object[0];
    }
}
