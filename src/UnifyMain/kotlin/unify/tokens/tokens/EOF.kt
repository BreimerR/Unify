package unify.tokens.tokens


import lib.io.FileClass
import lib.matcher.items.ItemsStatic
import lib.math.charVal
import lib.text.chars

class EOFStatic : CharacterStatic() {
    override val char = (-1).charVal

    override fun invoke(tokenString: String, l: Int, col: Int) = Class(tokenString, l, col)

    class Class(char: String, l: Int, col: Int) : CharacterStatic.Class(char, l, col, EOF)

}

val EOF = EOFStatic()