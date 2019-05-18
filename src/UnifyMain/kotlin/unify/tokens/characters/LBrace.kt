package unify.tokens.characters

import unify.tokens.tokens.CharacterClass
import unify.tokens.tokens.CharacterStatic

class LBraceStatic : CharacterStatic() {

    override val char = '{'

    override fun invoke(tokenString: String, l: Int, col: Int): LBRaceClass = LBRaceClass(tokenString, l, col)
}

class LBRaceClass(tokenString: String, l: Int, col: Int) : CharacterClass(tokenString, l, col) {
    override val self = LBrace
}

val LBrace = LBraceStatic()