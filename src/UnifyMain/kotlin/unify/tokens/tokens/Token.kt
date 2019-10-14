package unify.tokens.tokens

import lib.text.asString
import language.lib.io.FileClass
import lib.matcher.items.ItemsStatic
import language.tokens.TokenStatic  as LTokenStatic
import language.tokens.TokenStatic.Class as LTokenClass

abstract class TokenStatic : LTokenStatic() {

    abstract override operator fun invoke(tokenString: String, l: Int, col: Int): Class

    abstract val regex: Regex


    /**TODO
     * test is not as per requirements
     * */
    override fun test(file: FileClass): Boolean {
        // get the next char
        var string = arrayOf(file.nextChar)


        val bool = string.asString matches regex

        var runner = true

        while (runner) {
            string += file.nextChar
            runner = string.asString matches regex

            if (!runner) file.placeCursorAt(file.i - 1)
        }

        return bool
    }

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



