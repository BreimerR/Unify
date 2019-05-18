package unify.tokens.characters

import unify.tokens.CharacterClass
import unify.tokens.CharacterStatic
import unify.tokens.TokenClass


class EscapedRStatic : CharacterStatic() {
    override val char = '\r'

    override fun invoke(tokenString: String, l: Int, col: Int): EscapedRClass = EscapedRClass(tokenString, l, col)
}


class EscapedRClass(tokenString: String, l: Int, col: Int) : CharacterClass(tokenString, l, col) {
    override val self = EscapedR
}

val EscapedR = EscapedRStatic()
