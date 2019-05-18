package unify.tokens.characters

import unify.tokens.CharacterClass
import unify.tokens.CharacterStatic

val LSBracket = LSBracketStatic()


class LSBracketStatic : CharacterStatic() {

    override val char = '['

    override fun invoke(tokenString: String, l: Int, col: Int): LSBracketClass = LSBracketClass(tokenString, l, col)
}

class LSBracketClass(tokenString: String, l: Int, col: Int) : CharacterClass(tokenString, l, col) {
    override val self = LSBracket
}