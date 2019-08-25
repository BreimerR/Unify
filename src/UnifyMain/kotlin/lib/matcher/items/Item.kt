package lib.matcher.items


import lib.matcher.TestableStatic


abstract class ItemStatic : TestableStatic() {


    abstract class Class<T>(open val value: T) : TestableStatic.Class<T>() {
        override fun test(item: T) = false

        override fun collect(sI: Int, items: ItemsStatic.Class<T>): Array<Pair<String?, IntRange>> {
            return arrayOf(null to sI..items.i)
        }
    }

}
