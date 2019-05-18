package unify.tokens.characters

import unify.tokens.CharacterClass
import unify.tokens.CharacterStatic

val Pipe = PipeStatic()


class PipeStatic : CharacterStatic() {

    override val char = '|'


    override fun invoke(tokenString: String, l: Int, col: Int): PipeClass = PipeClass(tokenString, l, col)
}

class PipeClass(tokenString: String, l: Int, col: Int) : CharacterClass(tokenString, l, col) {
    override val self = Pipe
}