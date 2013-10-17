package name.webdizz.groovy.mopping.ast.interception

import name.webdizz.groovy.mopping.ast.classloader.AstClassLoader
import spock.lang.Specification


class AstInterceptionTest extends Specification {

    static def waiter

    def setupSpec() {
        def file = new File('src/main/groovy/name/webdizz/groovy/mopping/ast/interception/Waiter.groovy')
        AstClassLoader loader = new AstClassLoader()
        Class clazz = loader.parseClass(file)
        waiter = clazz.newInstance();
    }

    def 'should serve customer with nice food'() {
        String[] guests = ['Izzet']
        waiter.welcome(guests)
        String[] courses = ['Fagita']
        waiter.serve(guests, courses)
        expect:
        waiter.served.contains 'Izzet'
    }
}
