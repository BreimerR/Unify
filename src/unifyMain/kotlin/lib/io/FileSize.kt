package lib.io

import lib.oop.classes.Class
import lib.oop.classes.StaticClass

open class FileSizeStatic : StaticClass {
    operator fun invoke(s: Long): FileSizeClass = FileSizeClass(s)
}

open class FileSizeClass(val s: Long) : Class<FileSizeStatic>() {
    override val self = FileSize

    override fun toString(): String {
        return "${s}bytes"
    }
}


class BytesFileSizeStatic : FileSizeStatic()

class BytesFileSizeClass(s: Long) : FileSizeClass(s)

class KbFileSizeClass(s: Long) : FileSizeClass(s)

class KbFileSizeStatic(s: Long) : FileSizeClass(s)

val FileSize = FileSizeStatic()