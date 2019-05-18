package unify.tokens.characters

import unify.tokens.tokens.CharacterClass
import unify.tokens.tokens.CharacterStatic

val SQuotation = SQuotationStatic()


class SQuotationStatic : CharacterStatic() {

    override val char = '\''

    override fun invoke(tokenString: String, l: Int, col: Int): SQuotationClass = SQuotationClass(tokenString, l, col)
}


class SQuotationClass(tokenString: String, l: Int, col: Int) : CharacterClass(tokenString, l, col) {
    override val self = SQuotation
}