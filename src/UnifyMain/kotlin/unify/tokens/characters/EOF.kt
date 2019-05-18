package unify.tokens.characters

import lib.math.charVal
import unify.tokens.tokens.CharacterClass
import unify.tokens.tokens.CharacterStatic


val EOF = EOFStatic()


class EOFStatic : CharacterStatic() {

    override val char: Char = (-1).charVal

    override fun invoke(tokenString: String, l: Int, col: Int): EOFClass = EOFClass(tokenString, l, col)
}


class EOFClass(tokenString: String, l: Int, col: Int) : CharacterClass(tokenString, l, col) {
    override val self = EOF
}