package name.webdizz.groovy.mopping.ast.interception

class SuperVisor {
    static void audit(String name, args) {
        println '================<<'
        println "Auditing $name with args: $args"
    }

    static void auditAfter() {
        println '================>>'
    }
}
