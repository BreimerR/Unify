package lib.matcher

import lib.matcher.items.ItemsStatic

interface TestableStatic {

    abstract class Class<T> {

        abstract val self: TestableStatic

        abstract infix fun test(items: ItemsStatic.Class<T>): Boolean

        infix fun fail(items: ItemsStatic.Class<T>): Boolean {
            return !test(items)
        }
    }
}


