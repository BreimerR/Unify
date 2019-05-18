package unify.tokens.characters

import unify.tokens.tokens.CharacterClass
import unify.tokens.tokens.CharacterStatic

val RSBracket = RSBracketStatic()


class RSBracketStatic : CharacterStatic() {

    override var char = ']'

    override fun invoke(tokenString: String, l: Int, col: Int): RSBracketClass = RSBracketClass(tokenString, l, col)

}

class RSBracketClass(tokenString: String, l: Int, col: Int) : CharacterClass(tokenString, l, col) {
    override val self = RSBracket
}
