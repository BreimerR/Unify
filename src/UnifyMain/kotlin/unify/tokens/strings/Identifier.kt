package unify.tokens.strings

import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic
import unify.ast.TokensStatic
import unify.tokens.tokens.StringTokenClass
import unify.tokens.tokens.StringTokenStatic

open class IdentifierStatic : StringTokenStatic() {
    override fun invoke(tokenString: String, l: Int, col: Int) = Class(tokenString, l, col)

    override fun test(items: TokensStatic.Class): Boolean {

        items.nextItem?.let {

            val string =  it.value

            return string matches regex
        }

        return false
    }

    override var regex = Regex("([a-zA-Z][a-zA-Z0-9_]*|_+[a-zA-Z0-9_]*)")

    open class Class(tokenString: String, l: Int, col: Int) : StringTokenClass(tokenString, l, col) {
        override fun test(items: ItemsStatic.Class<String>) = false

        override val self = Identifier

    }
}


val Identifier = IdentifierStatic()

