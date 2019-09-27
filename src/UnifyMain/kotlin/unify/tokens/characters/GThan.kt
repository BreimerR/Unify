
package unify.tokens.characters


import unify.tokens.tokens.CharacterStatic

val GThan = GThanStatic()


class GThanStatic : CharacterStatic() {

    override val char = '>'

    override fun invoke(tokenString: String, l: Int, col: Int): Class = Class(tokenString, l, col)

    class Class(tokenString: String, l: Int, col: Int) : CharacterStatic.Class(tokenString, l, col, GThan)
}
