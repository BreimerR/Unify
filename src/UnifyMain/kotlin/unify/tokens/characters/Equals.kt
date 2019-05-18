package unify.tokens.characters

import unify.tokens.tokens.CharacterClass
import unify.tokens.tokens.CharacterStatic


class EqualsStatic : CharacterStatic() {
    override val char: Char = '='


    override fun invoke(tokenString: String, l: Int, col: Int): EqualsClass = EqualsClass(tokenString, l, col)

}

class EqualsClass(tokenString: String, l: Int, col: Int) : CharacterClass(tokenString, l, col) {
    override val self = Equals
}

val Equals = EqualsStatic()
