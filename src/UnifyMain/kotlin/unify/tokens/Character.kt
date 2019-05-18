package unify.tokens


import language.lib.os.File
import language.lib.os.FileClass
import lib.text.asString

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