package lib.regex

import lib.matcher.ItemClass as LItemClass
import lib.matcher.ItemStatic as LItemStatic

class ItemClass(override val value: Char) : LItemClass<Char>() {
    override val self = Item
}


class ItemStatic : LItemStatic() {
    operator fun invoke(char: Char): ItemClass = ItemClass(char)

}

val Item = ItemStatic()