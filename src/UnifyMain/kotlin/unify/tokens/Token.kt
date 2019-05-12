package unify.tokens

import language.tokens.TokenStatic
import language.tokens.TokenClass
import language.lib.os.File

abstract class TokenClass(val tkString: String) : TokenClass()

abstract class TokenStatic : TokenStatic() {
    abstract override operator fun invoke(tokenString: String, l: Int, col: Int): TokenClass

    abstract val regex: Regex

    override fun test(file: File): Boolean {
        var string = arrayOf(file.nextChar)

        val bool = string.asString matches regex

        var runner = true

        while (runner) {
            string += file.nextChar
            runner = string.asString matches regex

            if (!runner) file.cursorAt(file.i - 1)
        }

        return bool
    }
}



