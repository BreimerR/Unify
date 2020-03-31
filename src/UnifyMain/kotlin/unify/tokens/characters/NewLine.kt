package unify.tokens.characters

import lib.matcher.items.ItemStatic
import unify.tokens.tokens.CharacterStatic

class NewLineStatic : CharacterStatic() {

    override val TAG = "NewLine"

    override val char = '\n'

    override fun invoke(tokenString: String, l: Int, col: Int): Class = Class(tokenString, l, col)

    override fun testItem(item: ItemStatic.Class<String>?): Boolean {
        val test = if (item != null) item is Class else false

        debug(item, test)

        return test
    }

    class Class(tokenString: String, l: Int, col: Int) : CharacterStatic.Class(tokenString, l, col, NewLine) {
        override fun toString(): String = "\\n"
    }


}

val NewLine = NewLineStatic()