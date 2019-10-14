package unify.tokens.strings

import lib.matcher.items.ItemsStatic
import lib.text.asString
import unify.ast.TokensStatic
import unify.tokens.tokens.StringTokenClass
import unify.tokens.tokens.StringTokenStatic

class KeywordStatic(val value: String = "") : IdentifierStatic() {

    var keywords: String = "(infix|prefix|class|abstract|closed|trait|interface|public|static|void|null|when|for|if|elif|aka|else|get|set|switch|while|new|return|throw|import|do|TODO|todo)"


    override fun test(items: ItemsStatic.Class<String>): Boolean {

        if (super.test(items)) {
            items.currentItem?.value?.let {
                //return test && it matches keywords.toRegex()
                return it == value
            }
        }

        return false
    }

    override fun invoke(tokenString: String, l: Int, col: Int): Class = Class(tokenString, l, col)

    override fun test(items: ItemsStatic.Class<Char>): Boolean {
        val i = items.i

        return if (super.test(items))
            items[i..items.i].toTypedArray().asString matches keywords.toRegex()
        else false
    }

    class Class(tokenString: String, l: Int, col: Int) : IdentifierStatic.Class(tokenString, l, col) {
        override val self = Keyword
    }

}

val Keyword = KeywordStatic()