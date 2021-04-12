package unify.ast

import lib.matcher.items.ItemsStatic

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