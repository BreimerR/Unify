package language.lib.io


import kotlinx.cinterop.ExperimentalForeignApi
import lib.math.charVal
import lib.math.long
import lib.text.asString
import platform.posix.SEEK_SET
import platform.posix.fgetc
import platform.posix.fseek
import lib.io.FileClass as LibFileClass
import lib.io.FileStatic as LibFileStatic


class FileStatic : LibFileStatic() {
    operator fun invoke(fullFilePathWithExtension: String): FileClass {
        return FileClass(fullFilePathWithExtension)
    }


    fun open(fileName: String, mode: String = "r", action: FileClass.() -> Unit) {

        this(fileName).open(mode, action)
    }
}

@Suppress("UNUSED_PARAMETER")
class FileClass(private var fullFilePathWithExtension: String, var encoding: String = "UTF-8", dirSeparator: String = "/") :
        LibFileClass(fullFilePathWithExtension) {

    override val self = File

    @OptIn(ExperimentalForeignApi::class)
    val futureChar: Char
        get() {
            val cI = i.long
            fseek(file, 1, i)
            val char = fgetc(file)
            fseek(file, cI, SEEK_SET)
            return char.charVal
        }

    @OptIn(ExperimentalForeignApi::class)
    val copy: FileClass
        get() {
            val copy = File(fullFilePathWithExtension)
            copy.file = file
            copy.i = i
            return copy
        }


    fun open(mode: String = "r", action: FileClass.() -> Unit) {
        open(mode)

        apply(action)
    }


    fun getString(from: Int, to: Int): String {
        return getChars(from, to).asString
    }

    fun reverseCursor(charCount: Int = 1) {
        moveCursor(-charCount, i)
    }
}


var File = FileStatic()
