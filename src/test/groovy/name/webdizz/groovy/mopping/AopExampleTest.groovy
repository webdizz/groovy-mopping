package name.webdizz.groovy.mopping

import spock.lang.Specification

class AopImperceptibleExampleTest extends Specification {

    def 'should append world!'() {
        expect:
        'hello world!' == new AopImperceptibleExample().hello()
    }

    def 'should throw MissingMethodException'() {
        when:
        new AopImperceptibleExample().noSuchMethod()
        then:
        thrown(MissingMethodException)
    }
}

class AopMetaClassExampleTest extends Specification {

    def setup() {
        AopMetaClassExample.metaClass.invokeMethod = { String name, args ->
            def method = AopMetaClassExample.metaClass.getMetaMethod(name)
            String result = ''
            if (method) {
                result = method.invoke(delegate, args)
            } else {
                AopMetaClassExample.metaClass.invokeMissingMethod(delegate, name, args)
            }
            result + ' world!'
        }
    }

    def 'should append world for each method'() {
        def testingInstance = new AopMetaClassExample()
        expect:
        output == testingInstance."$method"()
        where:
        method    | output
        'hello'   | 'hello world!'
        'goodbye' | 'goodbye world!'
    }

    def 'should throw MissingMethodException'() {
        when:
        new AopMetaClassExample().noSuchMethod()
        then:
        thrown(MissingMethodException)
    }

}