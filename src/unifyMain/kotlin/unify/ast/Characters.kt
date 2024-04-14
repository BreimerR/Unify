package unify.ast

import lib.matcher.items.ItemsStatic

class CharactersStatic : ItemsStatic() {
    operator fun invoke(chars: Array<Char>): Class {
        return Class(chars.map {
            CharItem(it)
        })
    }

    class Class(
        override val items: MutableList<CharItemStatic.Class>
    ) : ItemsStatic.Class<Char>() {

        constructor(items: List<CharItemStatic.Class>) : this(items.toMutableList())

        override val self = Characters
    }
}

val Characters = CharactersStatic()
