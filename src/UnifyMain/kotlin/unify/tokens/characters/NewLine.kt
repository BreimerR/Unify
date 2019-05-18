package unify.tokens.characters

import unify.tokens.tokens.CharacterClass
import unify.tokens.tokens.CharacterStatic


class NewLineStatic : CharacterStatic() {
    override fun invoke(tokenString: String, l: Int, col: Int): NewLineClass {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val char = '\n'


}

class NewLineClass(tokenString: String, l: Int, col: Int) : CharacterClass(tokenString, l, col) {
    override val self = NewLine
}


var NewLine = NewLineStatic()
