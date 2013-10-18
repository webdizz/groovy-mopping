package name.webdizz.groovy.mopping

import spock.lang.Specification

class Processor {

    def methodMissing(String name, args) {
        println 'Synthesising new method'
        def methodImpl = { Object[] vargs ->
            println "Processing '${name}' with: ${vargs}"
            vargs
        }
        Processor instance = this
        instance.metaClass."$name" = methodImpl
        methodImpl(args)
    }
}

class SynthesisMethodMissingTest extends Specification {
    def 'should get result from missing method'() {
        expect:
        Processor processor = new Processor()
        processor.processString('Groovy') == ['Groovy']
        processor.processString('MOPping') == ['MOPping']

        processor.processInteger(1) == [1]
        processor.processInteger(4) == [4]
    }
}
