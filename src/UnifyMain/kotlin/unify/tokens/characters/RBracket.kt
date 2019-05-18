package unify.tokens.characters

import unify.tokens.tokens.CharacterClass
import unify.tokens.tokens.CharacterStatic

val RBracket = RBracketStatic()


class RBracketStatic : CharacterStatic() {

    override val char = ')'

    override fun invoke(tokenString: String, l: Int, col: Int): RBracketClass = RBracketClass(tokenString, l, col)
}

class RBracketClass(tokenString: String, l: Int, col: Int) : CharacterClass(tokenString, l, col) {
    override val self = RBracket
}