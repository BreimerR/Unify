package regex.items

import lib.matcher.items.ItemClass as LClass
import lib.matcher.items.ItemStatic as LItemStatic


class ItemStatic : LItemStatic() {
    operator fun invoke(char: Char, name: String = ""): Class = Class(char)


    class Class(override val value: Char) : LClass<Char>(value) {
        override val self = Item


        override fun compare(value: Char?): Boolean {
            return this.value == value
        }

        override fun toString(): String {
            return this.value.toString()
        }
    }


}

val Item = ItemStatic()