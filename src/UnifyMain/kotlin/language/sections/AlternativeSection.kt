package language.sections

import language.ast.TokensStatic
import language.parsers.unshift
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic
import unify.tokens.characters.NewLine
import unify.tokens.characters.Space
import unify.tokens.characters.Tab
import lib.matcher.sections.AlternativeSection as LAlternativeSection

class AlternativeSection(
        vararg altSections: TestableStatic<String>,
        val considerSpaces: Boolean = false,
        name: String? = null
) : LAlternativeSection<String>(name = name) {

    override val sections by lazy {
        if (!considerSpaces)
            altSections.unshift(
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
            ) else altSections
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