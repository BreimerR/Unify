package lib.matcher.items


import lib.matcher.TestableStatic

abstract class ItemClass<T>(open val value: T) : TestableStatic.Class<T>() {
    override fun test(items: ItemsStatic.Class<T>): Boolean {
        return this compare (items.nextItem)?.value
    }

    abstract infix fun compare(value: T?): Boolean
}

abstract class ItemStatic : TestableStatic()
