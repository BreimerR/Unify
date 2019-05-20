package lib.matcher

import lib.oop.classes.Class
import lib.oop.classes.StaticClass

abstract class ItemClass<T> : Class<ItemStatic>() {
    abstract val value: T
}

abstract class ItemStatic : StaticClass()
