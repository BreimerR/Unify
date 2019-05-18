package unify.tokens.characters

import unify.tokens.tokens.CharacterClass
import unify.tokens.tokens.CharacterStatic

class PercentStatic : CharacterStatic() {
    override val char = '%'

    override fun invoke(tokenString: String, l: Int, col: Int): PercentClass = PercentClass(tokenString, l, col)
}

class PercentClass(tokenString: String, l: Int, col: Int) : CharacterClass(tokenString, l, col) {
    override val self = Percent
}

val Percent = PercentStatic()
