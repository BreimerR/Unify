package unify.tokens.tokens


import lib.matcher.items.ItemsStatic
import lib.text.asString

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

    abstract override operator fun invoke(tokenString: String, l: Int, col: Int): Class

    abstract class Class(
            open val char: String,
            override val line: Int,
            override val col: Int,
            override val self: CharacterStatic) :
            TokenStatic.Class(char, line, col)

}

