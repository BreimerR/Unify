package language.parsers

import lib.matcher.sections.Section

open class Parser(
        vararg sections: Section<String>,
        name: String? = null
) : Section<String>(*sections, name = name) {

    open val considerSpaces = true

/*
    override fun test(items: ItemsStatic.Class<String>): Boolean {
        val i = items.i
        val test = super.test(items)
        items.i = i
        return test
    }*/
}