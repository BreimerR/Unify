package unify.tokens.strings

import lib.matcher.items.ItemsStatic
import unify.tokens.tokens.StringTokenClass
import unify.tokens.tokens.StringTokenStatic

class NumberStatic : StringTokenStatic() {

    override var regex = Regex("[0-9][0-9]*")

    override fun invoke(tokenString: String, l: Int, col: Int): Class = Class(tokenString, l, col)

    class Class(tokenString: String, l: Int, col: Int) : StringTokenClass(tokenString, l, col) {
        override fun test(items: ItemsStatic.Class<String>): Boolean {
            return false
        }

        override fun compare(value: String?): Boolean {
            return false
        }

        override val self = Number
    }
}

val Number = NumberStatic()