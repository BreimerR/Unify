package unify.tokens.characters

import unify.tokens.tokens.CharacterClass
import unify.tokens.tokens.CharacterStatic

val LThan = LThanStatic()

class LThanStatic : CharacterStatic() {

    override val char = '<'


    override fun invoke(tokenString: String, l: Int, col: Int): LThanClass = LThanClass(tokenString, l, col)
}

class LThanClass(tokenString: String, l: Int, col: Int) : CharacterClass(tokenString, l, col) {
    override val self = LThan
}
