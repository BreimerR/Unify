package unify.tokens.characters


import unify.tokens.CharacterClass
import unify.tokens.CharacterStatic

class HashStatic : CharacterStatic() {

    override val char = '#'

    override fun invoke(tokenString: String, l: Int, col: Int): HashClass = HashClass(tokenString, l, col)
}

class HashClass(tokenString: String, l: Int, col: Int) : CharacterClass(tokenString, l, col) {
    override val self = Hash
}

val Hash = HashStatic()
