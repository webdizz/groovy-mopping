package name.webdizz.groovy.mopping.ast

@groovy.transform.CompileStatic
class Waiter {

    void welcome(String[] guests) {
        println "Hello $guests"
    }

    void serve(String[] guests, String[] courses) {
        println "Serving $guests with $courses"
    }
}
