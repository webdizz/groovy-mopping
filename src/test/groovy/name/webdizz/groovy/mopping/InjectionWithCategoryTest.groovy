package name.webdizz.groovy.mopping

@Category(Long)
class CreditCardFormatter {
    def asCreditCardNumber() {
        String asString = toString()
        if (asString.size() == 16) {
            "${asString[0..3]}-${asString[4..7]}-${asString[8..11]}-${asString[12..15]}"
        }
    }
}

use(CreditCardFormatter) {
    assert 1214131415161527.asCreditCardNumber() == '1214-1314-1516-1527'
//    assert '1214131415161527'.asCreditCardNumber() == '1214-1314-1516-1527'
}