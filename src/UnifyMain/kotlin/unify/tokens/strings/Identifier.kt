package unify.tokens.strings

import lib.matcher.items.ItemStatic
import lib.matcher.items.ItemsStatic
import unify.tokens.tokens.StringTokenStatic

open class IdentifierStatic : StringTokenStatic() {

    override fun invoke(tokenString: String, l: Int, col: Int) = Class(tokenString, l, col)

    override var regex = Regex("([a-zA-Z][a-zA-Z0-9_]*|_+[a-zA-Z0-9_]*)")

    override fun testItem(item: ItemStatic.Class<String>?) = item is Class && item !is KeywordStatic.Class

    open class Class(tokenString: String, l: Int, col: Int) : StringTokenStatic.Class(tokenString, l, col) {

        override val self by lazy {
            Identifier
        }

    }
}


val Identifier = IdentifierStatic()

