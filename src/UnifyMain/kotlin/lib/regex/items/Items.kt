package regex.items


import lib.matcher.items.ItemsStatic.Class  as LItemsClass
import lib.matcher.items.ItemsStatic as LItemsStatic


class ItemsStatic : LItemsStatic<Char>() {
    operator fun invoke(testCase: String): Class {
        return Class(testCase)
    }

    // avoid using fixed char unicodes to support as many characters as the language it's self
    fun breaker(string: String): Array<ItemStatic.Class> {
        var items = arrayOf<ItemStatic.Class>()

        string.forEach {
            items += Item(it)
        }

        return items
    }

    class Class(testCase: String) : LItemsClass<Char>(Items.breaker(testCase)) {
        override val self = Items
    }
}


val Items = ItemsStatic()