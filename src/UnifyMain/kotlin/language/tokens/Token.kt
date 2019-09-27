package language.tokens


import language.lib.io.FileClass
import lib.matcher.items.ItemStatic
import lib.matcher.items.ItemsStatic

abstract class TokenStatic : ItemStatic<String>() {

    abstract infix fun test(file: FileClass): Boolean

    abstract infix fun test(items: ItemsStatic.Class<Char>): Boolean

    abstract operator fun invoke(tokenString: String, l: Int, col: Int): Class

    override fun collect(sI: Int, items: ItemsStatic.Class<String>): Array<Pair<String?, IntRange>> {
        TODO("Implement collect: language.tokens.Token.kt") //To change body of created functions use File | Settings | File Templates.
    }

    abstract class Class(tkString: String, open val l: Int, open val col: Int) : ItemStatic.Class<String>(tkString)
}
