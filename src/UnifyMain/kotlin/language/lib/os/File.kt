package language.lib.os


import lib.math.long
import lib.math.charVal
import lib.text.asString
import platform.posix.fgetc
import platform.posix.fseek
import lib.os.File as LibFile
import platform.posix.SEEK_SET


class File(var fileName: String, var fileEncoding: String) : LibFile(fileName, fileEncoding) {


    val futureChar: Char
        get() {
            val cI = i.long
            fseek(file, 1, i)
            val char = fgetc(file)
            fseek(file, cI, SEEK_SET)
            return char.charVal
        }

    val copy: File
        get() {
            val copy = File(fileName, fileEncoding)
            copy.file = file
            copy.i = i
            return copy
        }

    fun open(mode: String = "r", action: (File) -> Unit) {
        open(mode)
        // this will never be null since we are throwing error  file not found
        action(this)
    }


    fun getString(from: Int, to: Int): String {
        return getChars(from, to).asString
    }

    fun reverseCursor(charCount: Int = 1) {
        moveCursor(-charCount, i)
    }
}
