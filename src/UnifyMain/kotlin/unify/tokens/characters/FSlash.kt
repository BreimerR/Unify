package unify.tokens.characters

import unify.tokens.CharacterClass
import unify.tokens.CharacterStatic


class FSlashStatic : CharacterStatic() {

    override val char = '/'


    override fun invoke(tokenString: String, l: Int, col: Int): FSlashClass = FSlashClass(tokenString, l, col)
}

class FSlashClass(tokenString: String, l: Int, col: Int) : CharacterClass(tokenString, l, col) {
    override val self = FSlash
}


val FSlash = FSlashStatic()