package unify.tokens.characters

import lib.matcher.items.ItemStatic
import unify.tokens.tokens.CharacterStatic

class SpaceStatic : CharacterStatic() {

    override val char = ' '

    override fun invoke(tokenString: String, l: Int, col: Int): Class = Class(tokenString, l, col)

    override fun testItem(item: ItemStatic.Class<String>?) = if (item != null) item is Class else false

    class Class(tokenString: String, l: Int, col: Int) : CharacterStatic.Class(tokenString, l, col, Space) {
        override fun toString(): String = "${self::class.simpleName}  = \\s [$line,$col]"
    }

}

val Space = SpaceStatic()