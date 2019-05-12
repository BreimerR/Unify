package unify.tokens.characters

import unify.tokens.CharacterClass
import unify.tokens.CharacterStatic

class ColonStatic : CharacterStatic() {
    override fun invoke(tokenString: String, l: Int, col: Int): ColonClass {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val char = ':'
}

class ColonClass(char: Char, l: Int, col: Int) : CharacterClass(char, l, col) {
    override val self = Colon
}


val Colon = ColonStatic()