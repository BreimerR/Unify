package unify.tokens.tokens


import lib.text.asString
import language.lib.io.FileClass

fun Regex.Companion.char(char: Char): Regex = Regex(char.asString)


abstract class CharacterStatic : TokenStatic() {

    abstract val char: Char

    override val regex: Regex
        get() = Regex.char(char)

    override fun test(file: FileClass): Boolean {
        return file.nextChar == char
    }

    abstract override operator fun invoke(tokenString: String, l: Int, col: Int): CharacterClass
}


abstract class CharacterClass(open val char: String, override val l: Int, override val col: Int) : TokenClass(char, l, col)