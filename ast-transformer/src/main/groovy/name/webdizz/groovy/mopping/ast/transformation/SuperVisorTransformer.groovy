package name.webdizz.groovy.mopping.ast.transformation

import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.ast.ClassNode
import org.codehaus.groovy.ast.MethodNode
import org.codehaus.groovy.ast.expr.ArgumentListExpression
import org.codehaus.groovy.ast.expr.ConstantExpression
import org.codehaus.groovy.ast.expr.MethodCallExpression
import org.codehaus.groovy.ast.expr.VariableExpression
import org.codehaus.groovy.ast.stmt.ExpressionStatement
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation

@GroovyASTTransformation(phase = CompilePhase.SEMANTIC_ANALYSIS)
class SuperVisorTransformer implements ASTTransformation {

    @Override
    void visit(final ASTNode[] astNodes, final SourceUnit sourceUnit) {
        def classNode = astNodes?.find { it instanceof ClassNode && it.name.contains('Waiter') }
        injectAuditMethod(classNode)
    }

    static void injectAuditMethod(classNode) {
        def nonAuditMethods = classNode?.methods.findAll()
        nonAuditMethods?.each { injectMethodWithAudit(it) }
    }

    static void injectMethodWithAudit(MethodNode methodNode) {
        def before = new ExpressionStatement(
                new MethodCallExpression(
                        new VariableExpression('SuperVisor'),
                        'audit',
                        new ArgumentListExpression(new ConstantExpression(methodNode.name),
                                new ArgumentListExpression(methodNode.parameters))
                ))

        def after = new ExpressionStatement(
                new MethodCallExpression(
                        new VariableExpression('SuperVisor'),
                        'auditAfter', ArgumentListExpression.EMPTY_ARGUMENTS))
        methodNode.code.statements.add(0, before)
        methodNode.code.statements << after
    }
}
