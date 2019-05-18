package unify.tokens

import lib.text.asString
import language.lib.os.FileClass
import language.tokens.TokenStatic  as LTokenStatic
import language.tokens.TokenClass as LTokenClass

abstract class TokenClass(override val tkString: String, override val l: Int, override val col: Int) :
        LTokenClass(tkString, l, col)

abstract class TokenStatic : LTokenStatic() {
    abstract override operator fun invoke(tokenString: String, l: Int, col: Int): TokenClass

    abstract val regex: Regex


    /**TODO
     * test is not as per requirements
     * */
    override fun test(file: FileClass): Boolean {
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


}



