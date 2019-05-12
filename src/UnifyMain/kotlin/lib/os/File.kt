package lib.os

import kotlinx.cinterop.CPointer
import lib.math.charVal
import lib.math.long
import platform.posix.*

open class File(private val fileName: String, val encoding: String = "UTF-8") {
    var start = SEEK_SET
    var end = SEEK_END
    var i = SEEK_SET

    var file: CPointer<FILE>? = null

    val nextChar: Char
        get () {
            val char = fgetc(file).charVal
            // update current char index
            i += 1

            if (char == (-1).charVal) atEnd = true

            return char
        }

    val prevChar: Char
        get() {
            fseek(file, -1, i)
            val char = fgetc(file).charVal
            fseek(file, 1, SEEK_SET)
            atEnd = false
            return char
        }

    val isOpen: Boolean
        get() = file != null

    var atEnd: Boolean = false


    fun open(mode: String = "r") {
        file = fopen(fileName, mode)

        if (file == null) throw FileError("File $fileName does not exist")
    }

    open fun open(mode: String = "r", action: (File) -> Unit) {
        open(mode)
        // this will never be null since we are throwing error  file not found
        action(this)
    }

    fun safeOpen(mode: String = "r"): Boolean {
        return try {
            open(mode)
            true
        } catch (e: FileError) {
            false
        }
    }

    fun close(): Boolean {
        return if (isOpen) {
            fclose(file)
            true
        } else false
    }


    // SEEK_SET = beginning of the file
    fun moveCursor(to: Int, from: Int = SEEK_SET) {
        fseek(file, to.long, from)
        if (atEnd) {
            if (to < i) {
                atEnd = false
            }
        }
        i = to
    }

    fun cursorAt(position: Int) {
        moveCursor(position, start)
    }


    fun getChars(from: Int, to: Int): Array<Char> {
        cursorAt(from)

        var chars = arrayOf<Char>()


        for (i in 0 until (to - from)) {
            val char = nextChar
            chars += char
        }

        return chars
    }


}

class FileError(msg: String) : kotlin.Error(msg)
