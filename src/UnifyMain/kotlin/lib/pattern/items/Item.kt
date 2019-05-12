package lib.pattern.items

abstract class Item<T>(var value: T) {
    abstract fun test(items: Items<T>)
}