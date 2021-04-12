package lib.io

import lib.math.long
import lib.math.charVal
import platform.posix.*
import lib.oop.classes.Class
import kotlinx.cinterop.CPointer
import lib.oop.classes.StaticClass

open class FileStatic : StaticClass {
    operator fun invoke(fullFilePathWithExtension: String, dirSeparator: String = "/"): FileClass = FileClass(fullFilePathWithExtension)
}


open class FileClass(private val fullFilePathWithExtension: String) : Class<FileStatic>() {
    override val self = File

    var start = 0
    val seek
        get() = SEEK_CUR

    var end = SEEK_END
    var i = 0

    var file: CPointer<FILE>? = null

    var currentChar: Char? = null

    val nextChar: Char
        get() {
            currentChar = fgetc(file).charVal
            // update current char index

            if (currentChar == (-1).charVal) atEnd = true

            i += 1

            return currentChar!!
        }

    val prevChar: Char
        get() {
            fseek(file, -1, i)
            val char = fgetc(file).charVal
            fseek(file, 1, SEEK_SET)
            return char
        }

    val isOpen: Boolean
        get() = file != null

    var atEnd: Boolean = false


    fun open(mode: String = "r") {
        file = fopen(fullFilePathWithExtension, mode)
        if (file == null) throw FileError("File $fullFilePathWithExtension does not exist")
    }

    open fun open(mode: String = "r", action: FileClass.() -> Unit) {
        open(mode)
        // this will never be null since we are throwing error  file not found
        this.apply(action)
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
    fun moveCursor(to: Int, from: Int = i) {
        fseek(file, from.long, to)

        i = to
    }

    fun placeCursorAt(position: Int) {
        moveCursor(position, start)
    }


    fun getChars(from: Int, to: Int): Array<Char> {
        placeCursorAt(from)

        var chars = arrayOf<Char>()


        for (i in 0 until (to - from)) {
            val char = nextChar
            chars += char
        }

        return chars
    }


    val size: Long
        get() {
            moveCursor(end)

            val s = cursorPos

            moveCursor(start)

            return s
        }

    val fileSize: FileSizeClass
        get() {
            return FileSize(size)
        }

    private val cursorPos: Long
        get() {
            return ftell(file)
        }

    override fun toString(): String {
        return chars.string
    }


    val chars: Array<Char>
        get() {
            var f = arrayOf<Char>()

            while (!atEnd) f += nextChar

            return f
        }

}


val Array<Char>.string: String
    get() {
        return this.joinToString("")
    }

val File = FileStatic()