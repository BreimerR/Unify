package lib.matcher

import lib.oop.classes.StaticClass
import lib.oop.classes.Class as OClass
import lib.matcher.items.ItemsStatic.Class as ItemsClass

// should be typed as a testable for char is not a
// testable for string or any other type of object

abstract class TestableStatic : StaticClass() {


    abstract class Class<T> : OClass<TestableStatic>() {
        abstract infix fun test(items: ItemsClass<T>): Boolean

    }
}