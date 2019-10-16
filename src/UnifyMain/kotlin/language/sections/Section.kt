package language.sections

import language.ast.TokensStatic
import language.parsers.unshift
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic
import unify.tokens.characters.NewLine
import unify.tokens.characters.Space
import unify.tokens.characters.Tab
import lib.matcher.sections.Section as LSection

open class Section(
        vararg val sectionSections: TestableStatic<String>,
        open val considerSpaces: Boolean = false, name: String? = null
) : LSection<String>(name = name) {

    override val sections: Array<out TestableStatic<String>> by lazy {
        if (!considerSpaces) addStartSpaces(sectionSections)
        else sectionSections
    }


    fun addStartSpaces(sections: Array<out TestableStatic<String>>): Array<out TestableStatic<String>> {
        return sections.unshift(
                OptionalSection(
                        RepetitiveSection(
                                AlternativeSection(
                                        Tab,
                                        Space,
                                        NewLine,
                                        considerSpaces = true
                                ),
                                minCount = 1,
                                considerSpaces = true
                        ),
                        considerSpaces = true
                )
        )
    }

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