package unify.tokens.characters


import unify.tokens.tokens.CharacterClass
import unify.tokens.tokens.CharacterStatic

val LBracket = LBracketStatic()


class LBracketStatic : CharacterStatic() {
    override fun invoke(tokenString: String, l: Int, col: Int): LBracketClass = LBracketClass(tokenString, l, col)

    override val char = '('
}

class LBracketClass(tokenString: String, l: Int, col: Int) : CharacterClass(tokenString, l, col) {
    override val self = LBracket
}
