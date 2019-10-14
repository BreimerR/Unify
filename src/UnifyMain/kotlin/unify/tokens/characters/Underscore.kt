
package unify.tokens.characters


import unify.tokens.tokens.CharacterStatic

val Underscore = UnderscoreStatic()


class UnderscoreStatic : CharacterStatic() {

    override val char = '_'

    override fun invoke(tokenString: String, l: Int, col: Int): Class = Class(tokenString, l, col)

    class Class(tokenString: String, l: Int, col: Int) : CharacterStatic.Class(tokenString, l, col, Underscore)
}
