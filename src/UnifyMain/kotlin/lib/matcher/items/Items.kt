package lib.matcher.items

import lib.collections.array.length
import lib.oop.classes.StaticClass
import lib.matcher.items.ItemStatic.Class as ItemClass
import lib.oop.classes.Class as SClass

// regex char is item string is whole items
// language string is item statement is whole items

abstract class ItemsStatic : StaticClass {

    /** @DESCRIPTION
     * In this case ItemClass<T> is a Single token from the defined language
     * in our case it is a token from Unify tokenizer
     * other languages can have tokens as ItemClass<Char>
     * */
    abstract class Class<T>(items: Array<out ItemClass<T>>) : SClass<ItemsStatic>() {

        // THIS IS WRONG THIS IS VERY WRONG ITEMS SHOULD BE PASSED TO THE CLASS NOT LIKE THIS
        abstract val items: Array<out ItemClass<T>>

        constructor(vararg items: ItemClass<T>) : this(items)

        var i = 0

        var currentItem: ItemClass<T>? = null

        open val nextItem: ItemClass<T>?
            get() {
                if (hasRemItems) {
                    val res = items[i]
                    i += 1

                    currentItem = res

                    return res
                }

                return null
            }

        open val prevItem: ItemClass<T>?
            get() {
                return if (onFirstIndex) null
                else {
                    i -= 1

                    val res = items[i]

                    currentItem = res

                    res
                }
            }

        private val onFirstIndex: Boolean
            get() = i == 0

        private val hasPrevItems get() = i >= 0 && !onFirstIndex

        val hasRemItems: Boolean
            get() = items.length != 0 && i < items.length

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


