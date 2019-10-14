
package unify.tokens.characters


import unify.tokens.tokens.CharacterStatic

val EscapedR = EscapedRStatic()


class EscapedRStatic : CharacterStatic() {

    override val char = '\r'

    override fun invoke(tokenString: String, l: Int, col: Int): Class = Class(tokenString, l, col)

    class Class(tokenString: String, l: Int, col: Int) : CharacterStatic.Class(tokenString, l, col, EscapedR)
}
