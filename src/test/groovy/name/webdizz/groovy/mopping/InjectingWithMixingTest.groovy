package name.webdizz.groovy.mopping

class MixableCreditCardFormatter {
    def getAsCreditCardNumber() {
        String asString = this.toLong().toString()
        if (asString.size() == 16) {
            "${asString[0..3]}-${asString[4..7]}-${asString[8..11]}-${asString[12..15]}"
        }
    }
}
Long cardNumber = 1214131415161527

cardNumber.metaClass.mixin MixableCreditCardFormatter

println cardNumber.asCreditCardNumber