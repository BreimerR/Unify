package lib.matcher.items


import lib.matcher.TestableStatic


abstract class ItemStatic<T> : TestableStatic<T>() {

    abstract class Class<T>(open val value: T) : TestableStatic.Class<T>()

}
