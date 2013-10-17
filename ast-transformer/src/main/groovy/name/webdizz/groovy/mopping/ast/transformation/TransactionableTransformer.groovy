package name.webdizz.groovy.mopping.ast.transformation

import org.codehaus.groovy.ast.*
import org.codehaus.groovy.ast.builder.AstBuilder
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation
import org.objectweb.asm.Opcodes

@GroovyASTTransformation(phase = CompilePhase.SEMANTIC_ANALYSIS)
class TransactionableTransformer implements ASTTransformation {
    @Override
    void visit(final ASTNode[] astNodes, final SourceUnit sourceUnit) {
        println 'Hello from transformation'
        astNodes.findAll { it instanceof ClassNode }.each { ClassNode classNode ->
            def methodBody = new AstBuilder().buildFromCode {
                def instance = newInstance()
                try {
                    println "Opening transaction"
                    instance.with block
                } catch (Exception exc) {
                    println "Exception handling $exc"
                }
                finaly {
                    println "Closing transaction"
                }
            }
            def transactionalMethod = new MethodNode(
                    'transact',
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC,
                    ClassHelper.OBJECT_TYPE,
                    [new Parameter(ClassHelper.OBJECT_TYPE, 'block')] as Parameter[],
                    [] as ClassNode[],
                    methodBody[0]
            )

            classNode.addMethod(transactionalMethod)
        }
    }
}
