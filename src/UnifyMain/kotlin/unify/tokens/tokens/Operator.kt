package unify.tokens.tokens

import lib.matcher.TestableStatic
import lib.matcher.items.ItemStatic
import lib.matcher.items.ItemsStatic
import unify.ast.TokensStatic


abstract class OperatorStatic : TokenStatic() {
    abstract val tokenString: String

    override val regex: Regex
        get() = Regex("^$tokenString$")

    override fun test(items: ItemsStatic.Class<Char>): Boolean {

        var s = ""

        var bool = items.hasRemItems

        var i = 0

        while (bool) {

            val pI = items.i

            val char = items.nextItem?.value

            val test = if (i < tokenString.length) tokenString[i] == char else false

            if (test) s += char
            else items.i = pI

            i += 1

            bool = test && items.hasRemItems
        }

        return s.isNotEmpty()
    }

    override fun testItem(item: ItemStatic.Class<String>?) = item is Class

    // operators are key words and thus static no regular expression required
    abstract class Class(tokenString: String, l: Int, col: Int, override val self: OperatorStatic) :
            TokenStatic.Class(tokenString, l, col)

}

fun printLn(vararg message: Any?) = println(message.joinToString("\t"))
