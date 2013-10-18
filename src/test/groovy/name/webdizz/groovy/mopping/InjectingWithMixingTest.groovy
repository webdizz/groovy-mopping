package name.webdizz.groovy.mopping

import spock.lang.Specification

class MixableCreditCardFormatter {
    def getAsCreditCardNumber() {
        String asString = this.toLong().toString()
        if (asString.size() == 16) {
            "${asString[0..3]}-${asString[4..7]}-${asString[8..11]}-${asString[12..15]}"
        }
    }
}

class InjectingWithMixingTest extends Specification {

    def 'should get formatted credit card number'() {
        Long cardNumber = 1214131415161527
        cardNumber.metaClass.mixin MixableCreditCardFormatter
        expect:
        cardNumber.asCreditCardNumber == '1214-1314-1516-1527'
    }
}


