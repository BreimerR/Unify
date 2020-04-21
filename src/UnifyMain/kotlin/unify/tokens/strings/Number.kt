package unify.tokens.strings

import lib.matcher.items.ItemStatic
import unify.tokens.tokens.StringTokenStatic

class NumberStatic : StringTokenStatic() {

    override var regex = Regex("[0-9][0-9]*")

    override fun invoke(tokenString: String, l: Int, col: Int): Class = Class(tokenString, l, col)

    override fun testItem(item: ItemStatic.Class<String>?) = item is Class

    class Class(tokenString: String, l: Int, col: Int) : StringTokenStatic.Class(tokenString, l, col) {
        override val self by lazy {
            Number
        }
    }
}

val Number = NumberStatic()