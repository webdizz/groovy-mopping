package name.webdizz.groovy.mopping

Long.metaClass.getAsCreditCardNumber = {
    String asString = delegate.toString()
    if (asString.size() == 16) {
        "${asString[0..3]}-${asString[4..7]}-${asString[8..11]}-${asString[12..15]}"
    }
}

println 1214131415161527.asCreditCardNumber