package language.tokens


import System
import language.ast.TokensStatic
import lib.matcher.items.ItemStatic
import lib.matcher.items.ItemsStatic

abstract class TokenStatic : ItemStatic<String>() {

    abstract infix fun test(items: ItemsStatic.Class<Char>): Boolean

    abstract operator fun invoke(tokenString: String, l: Int, col: Int): Class

    override fun test(items: ItemsStatic.Class<String>): Boolean {

        items as TokensStatic.Class

        val test = testItem(items.nextToken)

        if (System.DEBUG_POSITIVES && test) println("$this value = ${items.token?.value}")

        return test

    }

    abstract fun testItem(item: ItemStatic.Class<String>?): Boolean

    abstract class Class(tkString: String, open val l: Int, open val col: Int) : ItemStatic.Class<String>(tkString)

}
