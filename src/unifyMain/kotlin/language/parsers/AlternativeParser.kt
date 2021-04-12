package language.parsers

import language.ast.TokensStatic
import language.sections.AlternativeSection
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic
import unify.Unify


open class AlternativeParser(
        vararg sections: TestableStatic<String>,
        considerSeparation: Boolean = false,
        considerSpaces: Boolean = false,
        considerNewLine: Boolean = false
) : AlternativeSection(
        *sections,
        considerSeparation = considerSeparation,
        considerSpaces = considerSpaces,
        considerNewLine = considerNewLine
) {

    override fun test(items: ItemsStatic.Class<String>): Boolean {

        val test = super.test(items)

        debug(items as TokensStatic.Class, test)

        return test
    }


}