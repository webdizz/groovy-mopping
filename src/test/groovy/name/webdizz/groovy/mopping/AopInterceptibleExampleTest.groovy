package name.webdizz.groovy.mopping

import spock.lang.Specification

class AopInterceptibleExampleTest extends Specification {

    def 'should append world!'() {
        expect:
        'hello world!' == new AopInterceptibleExample().hello()
    }

    def 'should throw MissingMethodException'() {
        when:
        new AopInterceptibleExample().noSuchMethod()
        then:
        thrown(MissingMethodException)
    }
}
