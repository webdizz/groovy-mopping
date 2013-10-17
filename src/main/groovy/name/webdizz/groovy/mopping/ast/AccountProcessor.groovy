package name.webdizz.groovy.mopping.ast

class AccountProcessor {

    Long balance = 0

    void debit(Long amount) {
        println "Debit: $amount"
    }

    void credit(Long amount) {
        println "Credit $amount"
    }
}
