package name.webdizz.groovy.mopping

import spock.lang.Specification

class AopExampleTest extends Specification {

    def 'shouldRunTest'(){
	expect:
	'hello world!' == new AopExample().hello()
    }
}