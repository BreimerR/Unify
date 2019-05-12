package unify.tokens.characters

import lib.os.File
import unify.tokens.CharacterStatic

class AmpersandStatic : CharacterStatic() {
    override fun invoke(tokenString: String, l: Int, col: Int): AmpersandClass {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun test(file: File): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class AmpersandClass : CharacterClass() {
    override operator fun invoke(tk: String): Ampersand {
        return Ampersand(char)
    }


    override var char = '&'
}
