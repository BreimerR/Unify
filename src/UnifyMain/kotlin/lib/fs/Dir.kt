package lib.fs

import lib.oop.classes.Class
import lib.oop.classes.StaticClass

class DirClass(loc: String) : Class<DirStatic>() {
    override val self = Dir

    val location = loc
}


class DirStatic : StaticClass() {
    operator fun invoke(location: String): DirClass {
        return DirClass(location)
    }

    val exists: Boolean
        get() {


            return false
        }
}

val Dir = DirStatic()