package name.webdizz.groovy.mopping

class AopIntercaptableExample implements GroovyInterceptable {

    def hello(){
	'hello'
    }

    def invokeMethod(String name, args){
	String result = AopIntercaptableExample.metaClass.invokeMethod(this, name)
	result + ' world!'	
    }
}

class AopMetaClassExample {

    def hello(){
	'hello'
    }

    def goodbye(){
	'goodbye'
    }
}