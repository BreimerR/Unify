package unify.tokens.characters

import unify.tokens.CharacterClass
import unify.tokens.CharacterStatic

val SColon = SColonStatic()

class SColonStatic : CharacterStatic() {

    override val char = ';'

    override fun invoke(tokenString: String, l: Int, col: Int): SColonClass = SColonClass(tokenString, l, col)
}


class SColonClass(tokenString: String, l: Int, col: Int) : CharacterClass(tokenString, l, col) {
    override val self = SColon
}