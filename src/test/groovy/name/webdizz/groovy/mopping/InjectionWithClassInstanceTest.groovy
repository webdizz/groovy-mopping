package name.webdizz.groovy.mopping

import spock.lang.Specification

class InjectionWithClassInstanceTest extends Specification {

    def 'should format credit card'() {
        setup:
        Long cardNumber = 1214131415161527

        def emc = new ExpandoMetaClass(Long)
        emc.getAsCreditCardNumber = {->
            String asString = delegate.toString()
            if (asString.size() == 16) {
                "${asString[0..3]}-${asString[4..7]}-${asString[8..11]}-${asString[12..15]}"
            }
        }
        emc.initialize()
        cardNumber.metaClass = emc

        expect:
        cardNumber.asCreditCardNumber == '1214-1314-1516-1527'
    }
}
