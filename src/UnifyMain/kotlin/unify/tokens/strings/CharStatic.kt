package unify.tokens.strings

import lib.matcher.items.ItemStatic
import lib.matcher.items.ItemsStatic

class CharStatic : IdentifierStatic() {

    override fun test(items: ItemsStatic.Class<Char>): Boolean {

        val char = items.nextItem?.value

        return if (char != null) {

            val c = "$char"

            if (c matches regex || isDigit(c)) {
                // save current index
                val nChar = items.nextItem?.value
                // check it's not a propagation of something else number or identifier
                val test = !(c + nChar matches regex || isDigit(c))

                items.goBack()

                test

            } else false

        } else false
    }

    fun isDigit(string: String) = string matches "[0-9]".toRegex()

    override fun testItem(item: ItemStatic.Class<String>?): Boolean = super.testItem(item) && item!!.value.length == 1

    override fun invoke(tokenString: String, l: Int, col: Int) = Class(tokenString, l, col)

    open class Class(tokenString: String, l: Int, col: Int) : IdentifierStatic.Class(tokenString, l, col) {

        override val self by lazy {
            Character
        }

    }
}

val Character = CharStatic()