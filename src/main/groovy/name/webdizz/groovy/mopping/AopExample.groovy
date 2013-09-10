package name.webdizz.groovy.mopping

class AopExample implements GroovyInterceptable {

    def hello(){
	'hello'
    }

    def invokeMethod(String name, args){
	System.out.println "Invoke method called for ${name}"
	String result = AopExample.metaClass.getMetaMethod(name).invoke this
	result + ' world!'
    }
}