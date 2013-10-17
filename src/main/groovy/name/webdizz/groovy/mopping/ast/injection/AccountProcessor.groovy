package name.webdizz.groovy.mopping.ast.injection

class AccountProcessor {

    Long balance = 0

    void debit(Long amount) {
        println "Debit: $amount"
        balance = balance + amount
    }

    void credit(Long amount) {
        println "Credit $amount"
        balance = balance - amount
    }
}
