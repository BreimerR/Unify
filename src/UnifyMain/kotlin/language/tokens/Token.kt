package language.tokens


import DEBUG
import DEBUG_NEGATIVES
import DEBUG_POSITIVES
import DEBUG_TOKENS
import Log
import language.ast.TokensStatic
import lib.matcher.items.ItemStatic
import lib.matcher.items.ItemsStatic

abstract class TokenStatic : ItemStatic<String>() {

    open val TAG = "TokenStatic"

    abstract infix fun test(items: ItemsStatic.Class<Char>): Boolean

    abstract operator fun invoke(tokenString: String, l: Int, col: Int): Class

    override fun test(items: ItemsStatic.Class<String>): Boolean {

        items as TokensStatic.Class

        val token = items.nextToken

        val test = testItem(token)


        debug(token, test)

        return test

    }

    fun debug(item: ItemStatic.Class<String>?, test: Boolean) {
        if (DEBUG && DEBUG_TOKENS) {

            if (DEBUG_POSITIVES && test) Log.d(TAG, " value = $item\ttest = $test")
            if (DEBUG_NEGATIVES && !test) Log.d(TAG, " value = $item\ttest = $test")

        }
    }

    abstract fun testItem(item: ItemStatic.Class<String>?): Boolean

    abstract class Class(tkString: String, open val line: Int, open val col: Int) : ItemStatic.Class<String>(tkString) {
        override fun toString(): String = value
    }

}
