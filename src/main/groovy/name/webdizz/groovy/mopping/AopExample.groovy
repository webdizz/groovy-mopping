package name.webdizz.groovy.mopping

class AopImperceptibleExample implements GroovyInterceptable {

    def hello() {
        'hello'
    }

    def invokeMethod(String name, args) {
        String result = AopImperceptibleExample.metaClass.invokeMethod(this, name)
        result + ' world!'
    }
}

class AopMetaClassExample {

    def hello() {
        'hello'
    }

    def goodbye() {
        'goodbye'
    }
}