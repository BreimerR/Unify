package unify.tokens.characters

import unify.tokens.CharacterClass
import unify.tokens.CharacterStatic


class DQuotationStatic : CharacterStatic() {
    override val char = '"'

    override operator fun invoke(tokenSring: String, l: Int, col: Int): DQuotationClass = DQuotationClass(tokenSring, l, col)
}


class DQuotationClass(tokenSring: String, l: Int, col: Int) : CharacterClass(tokenSring, l, col) {
    override val self = DQuotation
}

val DQuotation = DQuotationStatic()
