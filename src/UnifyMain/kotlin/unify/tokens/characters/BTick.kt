package unify.tokens.characters


import unify.tokens.tokens.CharacterClass
import unify.tokens.tokens.CharacterStatic

class BTickStatic : CharacterStatic() {
    override val char = '`'

    override fun invoke(tokenString: String, l: Int, col: Int): BTickClass {
        return BTickClass(tokenString, l, col)
    }
}


class BTickClass(tokenString: String, l: Int, col: Int) : CharacterClass(tokenString, l, col) {
    override val self = BTick
}

val BTick = BTickStatic()
