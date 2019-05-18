package language.tokens


import language.lib.os.FileClass
import lib.oop.classes.Class
import lib.oop.classes.StaticClass

abstract class TokenStatic : StaticClass() {
    abstract infix fun test(file: FileClass): Boolean

    abstract operator fun invoke(tokenString: String, l: Int, col: Int): TokenClass
}

abstract class TokenClass(open val tkString: String, open val l: Int, open val col: Int) : Class<TokenStatic>()
