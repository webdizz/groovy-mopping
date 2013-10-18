package name.webdizz.groovy.mopping

import spock.lang.Specification

class AnotherProcessor {

}

class SynthesisMethodMissingExpandoMetaClass extends Specification {

    def 'should test'() {
        setup:
        Processor.metaClass.methodMissing = { String name, args ->
            println 'Synthesising new method'
            def methodImpl = { Object[] vargs ->
                println "Processing '${name}' with: ${vargs}"
                vargs
            }
            Processor.metaClass."$name" = methodImpl
            methodImpl(args)
        }
        Processor processor = new Processor()

        expect:
        processor.processString('Groovy') == ['Groovy']
        processor.processString('MOPping') == ['MOPping']

        processor.processInteger(1) == [1]
        processor.processInteger(4) == [4]
    }
}
