package name.webdizz.groovy.mopping.ast

import name.webdizz.groovy.mopping.ast.classloader.AstClassLoader

def file = new File('../../../../../../../main/groovy/name/webdizz/groovy/mopping/ast/Transactionizer.groovy')
AstClassLoader loader = new AstClassLoader()
Class clazz = loader.parseClass(file)

def transactionizer = clazz.newInstance();

int money = 10
AccountProcessor accountProcessor1 = new AccountProcessor(balance: 100)
AccountProcessor accountProcessor2 = new AccountProcessor(balance: 150)

transactionizer.transact {
    accountProcessor2.credit(money)
    accountProcessor1.debit(money)
}

accountProcessor1.balance == 140
accountProcessor2.balance == 110