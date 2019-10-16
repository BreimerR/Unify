package language.sections

import language.ast.TokensStatic
import language.parsers.unshift
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic
import lib.matcher.sections.NotSection
import unify.tokens.characters.NewLine
import unify.tokens.characters.Space
import unify.tokens.characters.Tab

class NotSection(vararg sections: TestableStatic<String>, val considerSpaces: Boolean = false, name: String? = null) :
        NotSection<String>(name = name) {

    override val sections by lazy {

        if (!considerSpaces) sections.unshift(ZeroOrManySection(
                AlternativeSection(
                        NewLine,
                        Tab,
                        Space,
                        considerSpaces = true
                ),
                considerSpaces = true)
        ) else sections
    }

    // search algo required here to make the loop not linear exactly for performance boost
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