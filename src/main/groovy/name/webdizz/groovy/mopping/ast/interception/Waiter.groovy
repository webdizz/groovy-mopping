package name.webdizz.groovy.mopping.ast.interception

import groovy.transform.CompileStatic

class Waiter {

    List<String> served = []

    @CompileStatic
    void welcome(String[] guests) {
        println "Hello $guests"
    }

    @CompileStatic
    void serve(String[] guests, String[] courses) {
        println "Serving $guests with $courses"
        served.addAll guests
    }
}
