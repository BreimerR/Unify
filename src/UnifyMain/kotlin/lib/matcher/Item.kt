package lib.matcher

abstract class ItemClass<T> : TestableClass() {
    abstract val value: T
}

abstract class ItemStatic : TestableStatic()
