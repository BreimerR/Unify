package unify.tokens.tokens


import lib.text.asString
import language.lib.io.FileClass
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic
import unify.ast.TokensStatic

fun Regex.Companion.char(char: Char): Regex = Regex(char.asString)

abstract class CharacterStatic : TokenStatic() {

    abstract val char: Char

    override val regex: Regex
        get() = Regex.char(char)

    override fun test(items: ItemsStatic.Class<Char>): Boolean {
        items.nextItem?.let {
            return it.value == char
        }
        return false
    }
/*
    override fun test(items: ItemsStatic.Class<String>): Boolean {
        items.nextItem?.let {

            val string = it.value

            return string.length == 1 && string[0] == char

        }

        return false
    }*/

    abstract override operator fun invoke(tokenString: String, l: Int, col: Int): Class

    abstract class Class(
            open val char: String,
            override val l: Int,
            override val col: Int,
            override val self: CharacterStatic) :
            TokenStatic.Class(char, l, col)

}

