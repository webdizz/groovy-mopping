package name.webdizz.groovy.mopping.ast

import name.webdizz.groovy.mopping.ast.classloader.AstClassLoader
import name.webdizz.groovy.mopping.ast.injection.AccountProcessor
import spock.lang.Specification

class AstInjectionTest extends Specification {

    static def transactionizer

    def setupSpec() {
        def file = new File('src/main/groovy/name/webdizz/groovy/mopping/ast/injection/Transactionizer.groovy')
        AstClassLoader loader = new AstClassLoader()
        Class clazz = loader.parseClass(file)

        transactionizer = clazz.newInstance()
    }

    def 'should transfer balance'() {
        int money = 10
        AccountProcessor accountProcessor1 = new AccountProcessor(balance: 100)
        AccountProcessor accountProcessor2 = new AccountProcessor(balance: 150)

        transactionizer.transact {
            accountProcessor2.credit(money)
            accountProcessor1.debit(money)
        }
        expect:
        accountProcessor1.balance == 110
        accountProcessor2.balance == 140
    }
}

