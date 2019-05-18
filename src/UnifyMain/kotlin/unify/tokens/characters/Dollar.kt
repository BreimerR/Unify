package unify.tokens.characters

import unify.tokens.CharacterClass
import unify.tokens.CharacterStatic


class DollarStatic : CharacterStatic() {
    override val char = '$'

    override fun invoke(tokenString: String, l: Int, col: Int): DollarClass = DollarClass(tokenString, l, col)
}


class DollarClass(tokenString: String, l: Int, col: Int) : CharacterClass(tokenString, l, col) {
    override val self = Dollar
}

val Dollar = DollarStatic()
