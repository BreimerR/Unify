package unify.tokens.characters

import unify.tokens.CharacterClass
import unify.tokens.CharacterStatic

class AmpersandStatic : CharacterStatic() {
    override fun invoke(tokenString: String, l: Int, col: Int): AmpersandClass {
        return AmpersandClass(tokenString, l, col)
    }

    override val char = '&'
}

class AmpersandClass(tokenString: String, l: Int, col: Int) : CharacterClass(tokenString, l, col) {
    override val self = Ampersand
}


var Ampersand = AmpersandStatic()