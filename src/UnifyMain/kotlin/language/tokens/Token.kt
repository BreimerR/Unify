package language.tokens


import language.lib.io.FileClass
import lib.oop.classes.Class
import lib.oop.classes.StaticClass

abstract class TokenStatic : StaticClass() {
    abstract infix fun test(file: FileClass): Boolean

    abstract operator fun invoke(tokenString: String, l: Int, col: Int): Class

    abstract class Class(open val tkString: String, open val l: Int, open val col: Int) : Class<TokenStatic>()
}
