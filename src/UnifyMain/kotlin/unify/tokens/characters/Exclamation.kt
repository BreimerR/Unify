package unify.tokens.characters

import unify.tokens.tokens.CharacterClass
import unify.tokens.tokens.CharacterStatic


class ExclamationStatic : CharacterStatic() {
    override val char = '!'

    override fun invoke(tokenString: String, l: Int, col: Int): ExclamationClass = ExclamationClass(tokenString, l, col)
}

class ExclamationClass(tokenString: String, l: Int, col: Int) : CharacterClass(tokenString, l, col) {
    override val self = Exclamation
}

val Exclamation = ExclamationStatic()