
package unify.tokens.characters


import unify.tokens.tokens.CharacterStatic

val Dolar = DolarStatic()


class DolarStatic : CharacterStatic() {

    override val char = '$'

    override fun invoke(tokenString: String, l: Int, col: Int): Class = Class(tokenString, l, col)

    class Class(tokenString: String, l: Int, col: Int) : CharacterStatic.Class(tokenString, l, col, Dolar)
}
