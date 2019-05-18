package unify.tokens.characters

import unify.tokens.CharacterClass
import unify.tokens.CharacterStatic


val RBrace = RBraceStatic()

class RBraceStatic : CharacterStatic() {
    override val char = '}'

    override fun invoke(tokenString: String, l: Int, col: Int): RBraceClass = RBraceClass(tokenString, l, col)
}

class RBraceClass(tokenString: String, l: Int, col: Int) : CharacterClass(tokenString, l, col) {
    override val self = RBrace
}
