package name.webdizz.groovy.mopping.ast.interception

@groovy.transform.CompileStatic
class Waiter {

    List<String> served = []

    void welcome(String[] guests) {
        println "Hello $guests"
    }

    void serve(String[] guests, String[] courses) {
        println "Serving $guests with $courses"
        served.addAll guests
    }
}
