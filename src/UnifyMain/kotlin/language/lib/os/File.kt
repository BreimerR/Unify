package language.lib.os


import lib.math.charVal
import lib.math.long
import lib.text.asString

import platform.posix.fgetc
import platform.posix.fseek
import lib.os.FileClass as LibFileClass
import lib.os.FileStatic as LibFileStatic
import platform.posix.SEEK_SET


class FileStatic : LibFileStatic() {
    operator fun invoke(fullFilePathWithExtension: String): FileClass {
        return FileClass(fullFilePathWithExtension)
    }
}

class FileClass(var fullFilePathWithExtension: String, var encoding: String = "UTF-8", dirSeparator: String = "/") : LibFileClass(fullFilePathWithExtension) {

    override val self = File

    val futureChar: Char
        get() {
            val cI = i.long
            fseek(file, 1, i)
            val char = fgetc(file)
            fseek(file, cI, SEEK_SET)
            return char.charVal
        }

    val copy: FileClass
        get() {
            val copy = File(fullFilePathWithExtension)
            copy.file = file
            copy.i = i
            return copy
        }


    fun open(mode: String = "r", action: FileClass.() -> Unit) {
        open(mode)
        
        this.apply(action)
    }


    fun getString(from: Int, to: Int): String {
        return getChars(from, to).asString
    }

    fun reverseCursor(charCount: Int = 1) {
        moveCursor(-charCount, i)
    }
}


var File = FileStatic()

