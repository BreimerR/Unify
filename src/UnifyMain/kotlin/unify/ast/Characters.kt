package unify.ast

import lib.matcher.TestableStatic
import lib.matcher.items.ItemStatic
import lib.matcher.items.ItemsStatic


class CharItemStatic : ItemStatic() {
    override fun test(items: TokensStatic.Class): Boolean {
        return false
    }

    operator fun invoke(char: Char): Class = Class(char)


    class Class(char: Char) : ItemStatic.Class<Char>(char) {

        override val self = CharItem

        override fun test(items: ItemsStatic.Class<Char>): Boolean {
            return false
        }
    }
}

val CharItem = CharItemStatic()

class CharactersStatic : ItemsStatic() {
    operator fun invoke(chars: Array<Char>): Class {
        return Class(chars.map {
            CharItem(it)
        })
    }

    class Class(override val items: Array<CharItemStatic.Class>) : ItemsStatic.Class<Char>(items) {

        constructor(items: List<CharItemStatic.Class>) : this(items.toTypedArray())

        override val self = Characters
    }
}


val Characters = CharactersStatic()