
package unify.tokens.characters


import unify.tokens.tokens.CharacterStatic

val Tab = TabStatic()


class TabStatic : CharacterStatic() {

    override val char = '\t'

    override fun invoke(tokenString: String, l: Int, col: Int): Class = Class(tokenString, l, col)

    class Class(tokenString: String, l: Int, col: Int) : CharacterStatic.Class(tokenString, l, col, Tab)
}
