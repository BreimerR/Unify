package unify.tokens.characters

import unify.tokens.tokens.CharacterClass
import unify.tokens.tokens.CharacterStatic

val Space = SpaceStatic()


class SpaceStatic : CharacterStatic() {

    override val char = ' '

    override fun invoke(tokenString: String, l: Int, col: Int): SpaceClass = SpaceClass(tokenString, l, col)
}

class SpaceClass(tokenString: String, l: Int, col: Int) : CharacterClass(tokenString, l, col) {
    override val self = Space
}