package name.webdizz.groovy.mopping.ast.classloader

import name.webdizz.groovy.mopping.ast.transformation.TransactionableTransformer
import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.ast.ClassNode
import org.codehaus.groovy.classgen.GeneratorContext
import org.codehaus.groovy.control.CompilationUnit
import org.codehaus.groovy.control.SourceUnit

class AstInjectionOperation extends CompilationUnit.PrimaryClassNodeOperation {

    public void call(SourceUnit source, GeneratorContext context, ClassNode classNode) {
        ASTNode[] nodes = [classNode]
        new TransactionableTransformer().visit(nodes, source)
    }
}
