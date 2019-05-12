package lib.fs

import lib.oop.Class
import lib.oop.StaticClass

class DirClass(loc: String) : Class() {
    override val self = Dir

    val location = loc
}


class DirStatic : StaticClass<DirClass>() {
    operator fun invoke(location: String): DirClass {
        return DirClass(location)
    }

    val exists: Boolean
        get() {


            return false
        }
}

val Dir = DirStatic()