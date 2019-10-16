package language.sections

import language.ast.TokensStatic
import language.parsers.unshift
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic
import unify.tokens.characters.NewLine
import unify.tokens.characters.Space
import unify.tokens.characters.Tab
import lib.matcher.sections.RepetitiveSection as LRepetitiveSection


open class RepetitiveSection(
        vararg sectionSections: TestableStatic<String>,
        open val considerSpaces: Boolean = false,
        name: String? = null,
        minCount: Int = 0, maxCount: Int = 10000000
) : LRepetitiveSection<String>(name = name, minCount = minCount, maxCount = maxCount) {

    override val sections: Array<out TestableStatic<String>> by lazy {
        if (!considerSpaces) sectionSections.unshift(ZeroOrManySection(
                AlternativeSection(
                        NewLine,
                        Tab,
                        Space,
                        considerSpaces = true
                ),
                considerSpaces = true)
        ) else sectionSections
    }

    override infix fun test(items: ItemsStatic.Class<String>): Boolean {
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
