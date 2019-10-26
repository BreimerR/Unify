package unify.tokens.tokens

import lib.matcher.items.ItemStatic
import lib.matcher.items.ItemsStatic
import unify.tokens.strings.KeywordStatic


abstract class StringTokenStatic : TokenStatic() {

    override fun test(items: ItemsStatic.Class<String>): Boolean {
        return test(items.nextItem)
    }

    abstract fun test(item: ItemStatic.Class<String>?): Boolean

    abstract class Class(tokenString: String, l: Int, col: Int) : TokenStatic.Class(tokenString, l, col)
}


