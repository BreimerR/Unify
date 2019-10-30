package unify.tokens.tokens

import lib.matcher.items.ItemsStatic
import language.tokens.TokenStatic as LTokenStatic
import language.tokens.TokenStatic.Class as LTokenClass

abstract class TokenStatic : LTokenStatic() {

    abstract override operator fun invoke(tokenString: String, l: Int, col: Int): Class

    abstract val regex: Regex

    override fun test(items: ItemsStatic.Class<Char>): Boolean {

        var s = ""

        var bool = items.hasRemItems

        while (bool) {

            val i = items.i

            val char = items.nextItem?.value

            val test = s + char matches regex

            if (test) s += char
            else items.i = i

            bool = test && items.hasRemItems
        }

        return s.isNotEmpty()
    }

    abstract class Class(tkString: String, override val l: Int, override val col: Int) :
            LTokenClass(tkString, l, col)
}



