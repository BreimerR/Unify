package unify.tokens.strings

import lib.matcher.items.ItemsStatic
import unify.ast.TokensStatic
import unify.tokens.tokens.StringTokenClass
import unify.tokens.tokens.StringTokenStatic

class NumberStatic : StringTokenStatic() {
    override fun test(items: TokensStatic.Class): Boolean {
        return false
    }

    override var regex = Regex("[0-9][0-9]*")



    override fun invoke(tokenString: String, l: Int, col: Int): Class = Class(tokenString, l, col)

    class Class(tokenString: String, l: Int, col: Int) : StringTokenClass(tokenString, l, col) {
        override fun test(items: ItemsStatic.Class<String>) = false

        override val self = Number
    }
}

val Number = NumberStatic()