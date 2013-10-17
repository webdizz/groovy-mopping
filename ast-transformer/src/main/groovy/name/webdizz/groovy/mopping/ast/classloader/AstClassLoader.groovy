package name.webdizz.groovy.mopping.ast.classloader

import org.codehaus.groovy.control.CompilationUnit
import org.codehaus.groovy.control.CompilerConfiguration
import org.codehaus.groovy.control.Phases

import java.security.CodeSource

class AstClassLoader extends GroovyClassLoader {

    protected CompilationUnit createCompilationUnit(CompilerConfiguration config, CodeSource codeSource) {
        CompilationUnit compilationUnit = super.createCompilationUnit(config, codeSource)
        compilationUnit.addPhaseOperation(new AstInterceptionOperation(), Phases.CONVERSION)
        return compilationUnit
    }
}
