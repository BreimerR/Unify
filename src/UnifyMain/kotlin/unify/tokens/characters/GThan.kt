package unify.tokens.characters


import unify.tokens.CharacterClass
import unify.tokens.CharacterStatic

val GThan = GThanStatic()


class GThanStatic : CharacterStatic() {
    override val char = '>'

    override fun invoke(tokenString: String, l: Int, col: Int): GThanClass = GThanClass(tokenString, l, col)
}


class GThanClass(tokenString: String, l: Int, col: Int) : CharacterClass(tokenString, l, col) {
    override val self = GThan
}