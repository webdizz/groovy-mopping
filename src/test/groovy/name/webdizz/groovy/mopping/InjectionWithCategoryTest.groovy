package name.webdizz.groovy.mopping

import spock.lang.Specification
import spock.lang.Unroll

@Category(Long)
class CreditCardFormatter {
    def asCreditCardNumber() {
        String asString = toString()
        if (asString.size() == 16) {
            "${asString[0..3]}-${asString[4..7]}-${asString[8..11]}-${asString[12..15]}"
        }
    }
}


class InjectionWithCategoryTest extends Specification {

    @Unroll
    def 'should get formatted credit card number #expected from #input'() {
        String result
        when:
        use(CreditCardFormatter) {
            result = input.asCreditCardNumber()
        }
        then:
        result == expected
        where:
        input            | expected
        1214131415161527 | '1214-1314-1516-1527'
        1214131415161523 | '1214-1314-1516-1523'
//        '1214131415161527' | '1214-1314-1516-1527'
    }
}


