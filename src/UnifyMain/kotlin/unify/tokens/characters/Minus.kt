package unify.tokens.characters

import unify.tokens.tokens.CharacterClass
import unify.tokens.tokens.CharacterStatic

val Minus = MinusStatic()


class MinusStatic : CharacterStatic() {

    override val char = '-'

    override fun invoke(tokenString: String, l: Int, col: Int): MinusClass = MinusClass(tokenString, l, col)
}

class MinusClass(tokenString: String, l: Int, col: Int) : CharacterClass(tokenString, l, col) {
    override val self = Minus
}