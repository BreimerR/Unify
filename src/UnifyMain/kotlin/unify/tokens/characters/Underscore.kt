package unify.tokens.characters


import unify.tokens.CharacterClass
import unify.tokens.CharacterStatic

val Underscore = UnderscoreStatic()


class UnderscoreStatic : CharacterStatic() {

    override val char = '_'


    override fun invoke(tokenString: String, l: Int, col: Int): UnderscoreClass = UnderscoreClass(tokenString, l, col)
}

class UnderscoreClass(tokenString: String, l: Int, col: Int) : CharacterClass(tokenString, l, col) {
    override val self = Underscore
}