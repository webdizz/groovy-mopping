package name.webdizz.groovy.mopping

class AopInterceptibleExample implements GroovyInterceptable {

    def hello() {
        'hello'
    }

    def invokeMethod(String name, args) {
        String result = AopInterceptibleExample.metaClass.invokeMethod(this, name)
        result + ' world!'
    }
}
