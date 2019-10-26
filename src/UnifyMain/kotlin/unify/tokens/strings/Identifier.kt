package unify.tokens.strings

import lib.matcher.items.ItemStatic
import unify.tokens.tokens.StringTokenStatic

open class IdentifierStatic : StringTokenStatic() {

    override fun test(item: ItemStatic.Class<String>?): Boolean {
        return item is Class
    }

    override fun invoke(tokenString: String, l: Int, col: Int) = Class(tokenString, l, col)

    override var regex = Regex("([a-zA-Z][a-zA-Z0-9_]*|_+[a-zA-Z0-9_]*)")

    open class Class(tokenString: String, l: Int, col: Int) : StringTokenStatic.Class(tokenString, l, col) {
        override val self = Identifier
    }
}


val Identifier = IdentifierStatic()

