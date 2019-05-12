package lib.pattern.items

abstract class Items<T> {

    var items: Array<Item<T>> = arrayOf()

    operator fun plus(item: Item<T>): Array<Item<T>> {
        items += item
        return items
    }

    var i = -1
    val increment: Unit
        inline get() {
            i += 1
        }

    val nextItem: Item<T>
        get() = this[++i]


    operator fun get(i: Int): Item<T> {
        return items[i]
    }

    val currentItem: Item<T>?
        get() = try {
            this[i]
        } catch (e: Exception) {
            null
        }


    val size: Int
        get() = items.size

    val hasItems: Boolean
        get() = size > 0 && i < size

    fun each(func: (Item<T>) -> Unit) {
        while (hasItems) {
            func(nextItem)
        }
    }


}