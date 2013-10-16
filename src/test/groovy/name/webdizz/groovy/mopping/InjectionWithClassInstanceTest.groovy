package name.webdizz.groovy.mopping

Long cardNumber = 1214131415161527

emc = new ExpandoMetaClass(Long)
emc.getAsCreditCardNumber = {->
    String asString = delegate.toString()
    if (asString.size() == 16) {
        "${asString[0..3]}-${asString[4..7]}-${asString[8..11]}-${asString[12..15]}"
    }
}
emc.initialize()
cardNumber.metaClass = emc

println cardNumber.asCreditCardNumber