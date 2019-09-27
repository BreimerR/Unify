
package unify.tokens.characters


import unify.tokens.tokens.CharacterStatic

val NewLine = NewLineStatic()


class NewLineStatic : CharacterStatic() {

    override val char = '\n'

    override fun invoke(tokenString: String, l: Int, col: Int): Class = Class(tokenString, l, col)

    class Class(tokenString: String, l: Int, col: Int) : CharacterStatic.Class(tokenString, l, col, NewLine)
}
