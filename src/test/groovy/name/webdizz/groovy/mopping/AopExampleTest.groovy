package name.webdizz.groovy.mopping

import spock.lang.Specification

class AopExampleTest extends Specification {

    def 'should append world!'(){
	expect:
	'hello world!' == new AopExample().hello()
    }

    def 'should throw MissingMethodException'(){
	when:
	new AopExample().noSuchMethod()
	then:
	thrown(MissingMethodException)
    }
}