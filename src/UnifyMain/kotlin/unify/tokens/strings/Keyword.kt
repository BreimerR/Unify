package unify.tokens.strings

import lib.matcher.items.ItemsStatic
import lib.text.asString
import unify.tokens.tokens.StringTokenClass
import unify.tokens.tokens.StringTokenStatic

class KeywordStatic : IdentifierStatic() {

    var keywords: String = "(infix|prefix|class|abstract|closed|trait|interface|public|static|void|null|when|for|if|elif|aka|else|get|set|switch|while|new|return|throw|import|do|TODO|todo)"

    override fun invoke(tokenString: String, l: Int, col: Int): Class = Class(tokenString, l, col)

    override fun test(items: ItemsStatic.Class<Char>): Boolean {
        val i = items.i

        return if (super.test(items))
            items[i..items.i].toTypedArray().asString matches keywords.toRegex()
        else false
    }

    class Class(tokenString: String, l: Int, col: Int) : IdentifierStatic.Class(tokenString, l, col) {
        override fun test(items: ItemsStatic.Class<String>): Boolean {
            return false
        }

        override fun compare(value: String?): Boolean {
            return false
        }

        override val self = Keyword

        infix fun iS(string: String) = value == string

    }

}

val Keyword = KeywordStatic()