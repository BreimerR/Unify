package language.sections

import language.ast.TokensStatic
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic
import lib.matcher.sections.OneOrManySection as LOneOrManySection


class OneOrManySection(
        vararg sections: TestableStatic<String>,
        name: String? = null,
        minCount: Int = 1,
        maxCount: Int = 50000,
        val considerSpaces: Boolean = false) :
        LOneOrManySection<String>(*sections, name = name, minCount = minCount, maxCount = maxCount) {

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