package language.tokens


import lib.matcher.items.ItemStatic
import lib.matcher.items.ItemsStatic

abstract class TokenStatic : ItemStatic<String>() {

    abstract infix fun test(items: ItemsStatic.Class<Char>): Boolean

    abstract operator fun invoke(tokenString: String, l: Int, col: Int): Class

    override fun test(items: ItemsStatic.Class<String>): Boolean {
        return  testItem(items.nextItem)
    }

    abstract fun testItem(item: ItemStatic.Class<String>?): Boolean

    abstract class Class(tkString: String, open val l: Int, open val col: Int) : ItemStatic.Class<String>(tkString)
}
