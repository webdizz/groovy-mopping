package name.webdizz.groovy.mopping

class AnotherProcessor {

}

Processor.metaClass.methodMissing = { String name, args ->
    println 'Synthesising new method'
    def methodImpl = { Object[] vargs ->
        println "Processing '${name}' with: ${vargs}"
    }
    Processor.metaClass."$name" = methodImpl
    methodImpl(args)
}
Processor processor = new Processor()
processor.processString('Groovy')
processor.processString('MOPping')

processor.processInteger(1)
processor.processInteger(4)