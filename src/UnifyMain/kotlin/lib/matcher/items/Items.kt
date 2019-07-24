package lib.matcher.items

import lib.collections.array.length
import lib.oop.classes.Class as SClass
import lib.oop.classes.StaticClass


abstract class ItemsStatic<T> : StaticClass() {

    abstract class Class<T>(open val items: Array<out ItemClass<T>>) : SClass<ItemsStatic<T>>() {

        var i = 0


        var currentItem: ItemClass<T>? = null

        val nextItem: ItemClass<T>?
            get() {
                if (hasRemItems) {
                    val res = items[i]
                    i += 1

                    currentItem = res

                    return res
                }

                return null
            }

        val hasRemItems: Boolean
            get () {
                return items.length != 0 && i < items.length
            }


        operator fun get(index: Int): ItemClass<T> = items[index]

        operator fun get(range: IntRange): List<T> {
            var items = arrayOf<ItemClass<T>>()

            val f = range.first
            val l = range.last

            for (i in f until l) {
                items += this.items[i]
            }

            return items.map { it.value }
        }
    }

}


