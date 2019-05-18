package unify.tokens.characters

import unify.tokens.CharacterClass
import unify.tokens.CharacterStatic

val SLine = SLineStatic()


class SLineStatic : CharacterStatic() {

    override val char = '~'

    override fun invoke(tokenString: String, l: Int, col: Int): SLineClass = SLineClass(tokenString, l, col)
}


class SLineClass(tokenString: String, l: Int, col: Int) : CharacterClass(tokenString, l, col) {
    override val self = SLine
}