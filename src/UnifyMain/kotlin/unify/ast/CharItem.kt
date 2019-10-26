package unify.ast

import lib.matcher.items.ItemStatic
import lib.matcher.items.ItemsStatic


class CharItemStatic : ItemStatic<Char>() {

    override fun test(items: ItemsStatic.Class<Char>): Boolean {
        return false
    }

    operator fun invoke(char: Char): Class = Class(char)


    class Class(char: Char) : ItemStatic.Class<Char>(char) {

        override val self = CharItem

    }
}

val CharItem = CharItemStatic()


