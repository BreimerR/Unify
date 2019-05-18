package unify.tokens.characters

import unify.tokens.CharacterClass
import unify.tokens.CharacterStatic


class DotStatic : CharacterStatic() {
    override val char = '.'

    override fun invoke(tokenString: String, l: Int, col: Int): DotClass = DotClass(tokenString, l, col)
}


class DotClass(tokenString: String, l: Int, col: Int) : CharacterClass(tokenString, l, col) {

    override val self = Dot
}

val Dot = DotStatic()
