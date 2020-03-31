package unify.tokens.tokens


import lib.matcher.items.ItemStatic
import lib.math.charVal

class EOFStatic : CharacterStatic() {
    override val char = (-1).charVal

    override fun invoke(tokenString: String, l: Int, col: Int) = Class(tokenString, l, col)

    override fun testItem(item: ItemStatic.Class<String>?) = item is Class

    class Class(char: String, l: Int, col: Int) : CharacterStatic.Class(char, l, col, EOF)

}

val EOF = EOFStatic()