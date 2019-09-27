package unify.ast

import lib.matcher.TestableStatic
import lib.matcher.items.ItemStatic
import lib.matcher.items.ItemsStatic


class CharItemStatic : ItemStatic<Char>() {
    override fun collect(sI: Int, items: ItemsStatic.Class<Char>): Array<Pair<String?, IntRange>> {
        TODO("Implement collect: Characters.kt")
    }

    override fun test(items: ItemsStatic.Class<Char>): Boolean {
        return false
    }


    operator fun invoke(char: Char): Class = Class(char)


    class Class(char: Char) : ItemStatic.Class<Char>(char) {

        override val self = CharItem

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