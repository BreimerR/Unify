package unify.tokens.strings

import lib.matcher.items.ItemStatic
import lib.matcher.items.ItemsStatic
import unify.tokens.tokens.StringTokenStatic

class NumberStatic : StringTokenStatic() {

    override fun test(item: ItemStatic.Class<String>?): Boolean {
        return item is Class
    }

    override var regex = Regex("[0-9][0-9]*")

    override fun invoke(tokenString: String, l: Int, col: Int): Class = Class(tokenString, l, col)

    class Class(tokenString: String, l: Int, col: Int) : StringTokenStatic.Class(tokenString, l, col) {
        override val self = Number
    }
}

val Number = NumberStatic()