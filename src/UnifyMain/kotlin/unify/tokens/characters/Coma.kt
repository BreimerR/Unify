package unify.tokens.characters

import unify.tokens.tokens.CharacterClass
import unify.tokens.tokens.CharacterStatic


class ComaStatic : CharacterStatic() {
    override val char = ':'

    override fun invoke(tokenString: String, l: Int, col: Int): ComaClass = ComaClass(tokenString, l, col)
}


class ComaClass(tkString: String, l: Int, col: Int) : CharacterClass(tkString, l, col) {
    override val self = Coma
}


val Coma = ComaStatic()
