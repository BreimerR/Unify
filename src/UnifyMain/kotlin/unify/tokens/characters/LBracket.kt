
package unify.tokens.characters


import unify.tokens.tokens.CharacterStatic

val LBracket = LBracketStatic()


class LBracketStatic : CharacterStatic() {

    override val char = '('

    override fun invoke(tokenString: String, l: Int, col: Int): Class = Class(tokenString, l, col)

    class Class(tokenString: String, l: Int, col: Int) : CharacterStatic.Class(tokenString, l, col, LBracket)
}
