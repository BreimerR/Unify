package language.sections

import language.ast.TokensStatic
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic
import lib.matcher.sections.OptionalSection as LOptionalSection


open class OptionalSection(
        vararg sections: TestableStatic<String>,
        val considerSpaces: Boolean = false,
        name: String? = null) :
        LOptionalSection<String>(*sections, name = name) {

    override fun test(items: ItemsStatic.Class<String>): Boolean {
        return if (items is TokensStatic.Class) {
            val spaceCons = items.considerSpaces

            items.considerSpaces = considerSpaces
            val t = super.test(items)
            items.considerSpaces = spaceCons
            t
        } else {
            super.test(items)
        }
    }
}