package unify.tokens.characters

import System
import lib.matcher.items.ItemStatic
import unify.tokens.tokens.CharacterStatic

class NewLineStatic : CharacterStatic() {

    override val char = '\n'

    override fun invoke(tokenString: String, l: Int, col: Int): Class = Class(tokenString, l, col)

    override fun testItem(item: ItemStatic.Class<String>?): Boolean {
        val test = if (item != null) item is Class else false

        println("$item test  = $test")

        if(System.DEBUG_POSITIVES && test) println("NewLine = ${item}")

        return test
    }

    class Class(tokenString: String, l: Int, col: Int) : CharacterStatic.Class(tokenString, l, col, NewLine)

}

val NewLine = NewLineStatic()