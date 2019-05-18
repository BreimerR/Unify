package unify.tokens.characters

import unify.tokens.CharacterClass
import unify.tokens.CharacterStatic

class AmpersandStatic : CharacterStatic() {

    operator fun invoke(): AmpersandClass {
        return AmpersandClass(char);
    }

    override val char = '&'
}

class AmpersandClass(override val char: Char) : CharacterClass(char) {
    override val self = Ampersand
}


var Ampersand = AmpersandStatic()