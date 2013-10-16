package name.webdizz.groovy.mopping.ast

import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.ast.ClassNode
import org.codehaus.groovy.classgen.GeneratorContext
import org.codehaus.groovy.control.CompilationUnit
import org.codehaus.groovy.control.CompilationUnit.PrimaryClassNodeOperation
import org.codehaus.groovy.control.CompilerConfiguration
import org.codehaus.groovy.control.Phases
import org.codehaus.groovy.control.SourceUnit

import java.security.CodeSource

class TestHarnessClassLoader extends GroovyClassLoader {

    protected CompilationUnit createCompilationUnit(CompilerConfiguration config, CodeSource codeSource) {
        CompilationUnit compilationUnit = super.createCompilationUnit(config, codeSource)
        compilationUnit.addPhaseOperation(new TestHarnessOperation(), Phases.CONVERSION)
        return compilationUnit
    }
}

class TestHarnessOperation extends PrimaryClassNodeOperation {

    public void call(SourceUnit source, GeneratorContext context, ClassNode classNode) {
        ASTNode[] nodes = [classNode]
        new SuperVisorTransformer().visit(nodes, source)
    }
}

def file = new File('../../../../../../../main/groovy/name/webdizz/groovy/mopping/ast/Waiter.groovy')
TestHarnessClassLoader loader = new TestHarnessClassLoader()
Class clazz = loader.parseClass(file)
def waiter = clazz.newInstance();
String[] guests = ['Izzet']
waiter.welcome(guests)
String[] courses = ['Fagita']
waiter.serve(guests, courses)
