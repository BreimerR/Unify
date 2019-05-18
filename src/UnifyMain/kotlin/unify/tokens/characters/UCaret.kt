package unify.tokens.characters


import unify.tokens.CharacterClass
import unify.tokens.CharacterStatic

val UCaret = UCaretStatic()


class UCaretStatic : CharacterStatic() {

    override val char = '^'

    override fun invoke(tokenString: String, l: Int, col: Int): UCaretClass = UCaretClass(tokenString, l, col)
}


class UCaretClass(tokenString: String, l: Int, col: Int) : CharacterClass(tokenString, l, col) {
    override val self = UCaret
}