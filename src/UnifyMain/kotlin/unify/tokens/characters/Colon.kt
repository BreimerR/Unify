package unify.tokens.characters

import unify.tokens.tokens.CharacterClass
import unify.tokens.tokens.CharacterStatic

class ColonStatic : CharacterStatic() {
    override fun invoke(tokenString: String, l: Int, col: Int): ColonClass = ColonClass(tokenString, l, col)

    override val char = ':'
}

class ColonClass(tokenString: String, l: Int, col: Int) : CharacterClass(tokenString, l, col) {
    override val self = Colon
}


val Colon = ColonStatic()