package unify.tokens


import lib.os.File
import lib.text.asString

fun Regex.Companion.char(char: Char): Regex = Regex(char.asString)


abstract class CharacterStatic : TokenStatic() {

    abstract val char: Char

    override val regex: Regex
        get() = Regex.char(char)

    override fun test(file: File): Boolean {
        return file.nextChar == char
    }

    operator fun invoke(file: File, from: Int, to: Int): CharacterClass {
        file.moveCursor(from, to)
        return this(file.nextChar.asString)
    }

}


abstract class CharacterClass(char: Char, l: Int, col: Int) : TokenClass(char.asString, l, col)