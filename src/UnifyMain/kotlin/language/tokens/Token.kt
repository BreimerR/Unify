package language.tokens

import lib.oop.Class
import lib.oop.StaticClass
import language.lib.os.File

abstract class TokenStatic : StaticClass() {
    abstract fun test(file: File): Boolean

    abstract operator fun invoke(tokenString: String, l: Int, col: Int): TokenClass
}

abstract class TokenClass : Class<TokenStatic>()
