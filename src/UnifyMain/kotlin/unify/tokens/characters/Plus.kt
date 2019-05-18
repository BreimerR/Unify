package unify.tokens.characters

import unify.tokens.CharacterClass
import unify.tokens.CharacterStatic


val Plus = PlusStatic()

class PlusStatic : CharacterStatic() {

    override val char = '+'

    override fun invoke(tokenString: String, l: Int, col: Int): PlusClass = PlusClass(tokenString, l, col)
}

class PlusClass(tokenString: String, l: Int, col: Int) : CharacterClass(tokenString, l, col) {
    override val self = Plus
}
