package lib.matcher

import lib.matcher.items.ItemsStatic
import lib.oop.classes.StaticClass

abstract class TestableStatic<T> : StaticClass {

    abstract infix fun test(items: ItemsStatic.Class<T>): Boolean

    infix fun fail(items: ItemsStatic.Class<T>): Boolean = !test(items)

    abstract class Class<T> : lib.oop.classes.Class<TestableStatic<T>>()

}


