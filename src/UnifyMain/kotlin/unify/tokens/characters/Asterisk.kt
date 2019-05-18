package unify.tokens.characters

import unify.tokens.tokens.CharacterClass
import unify.tokens.tokens.CharacterStatic


class AsteriskStatic : CharacterStatic() {
    override val char: Char = '*'

    override fun invoke(tokenString: String, l: Int, col: Int): AmpersandClass {
        return AmpersandClass(tokenString, l, col)
    }
}


class AsteriskClass(tokenString: String, l: Int, col: Int) : CharacterClass(tokenString, l, col) {
    override val self = Asterisk

}

val Asterisk = AsteriskStatic()
