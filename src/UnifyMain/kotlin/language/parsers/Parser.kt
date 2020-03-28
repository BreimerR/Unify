package language.parsers

import language.sections.AlternativeSection
import language.sections.Section
import language.sections.ZeroOrMany
import lib.matcher.TestableStatic
import unify.tokens.characters.NewLine
import unify.tokens.characters.Space
import unify.tokens.characters.Tab

open class ParserStatic(
        vararg sections: TestableStatic<String>,
        considerSeparation: Boolean = false,
        considerSpaces: Boolean = false,
        considerNewLine: Boolean = false,
        name: String? = null
) : Section(
        *if (considerSeparation) arrayOf(
                ZeroOrMany(
                        // consume previous spaces and tabs before next parse test or parse
                        AlternativeSection(
                                Tab, Space, NewLine,
                                considerSeparation = true
                        )
                ), *sections
        ) else sections,
        considerSeparation = considerSeparation,
        considerNewLine = considerNewLine,
        considerSpaces = considerSpaces,
        name = name
) {
   /* parser does not need to override does not make sense

    override fun test(items: ItemsStatic.Class<String>): Boolean {

        items as TokensStatic.Class

        items.saveState

        items.updateStates(
                considerSpaces,
                considerNewLine,
                considerSeparation
        )

        val test = super.test(items)

        items.restoreState

        if (System.DEBUG_POSITIVE_PARSERS && test) println("$this Returns $test \t token =  ${items.token}  \t token.i = ${items.i} ")

        return test
    }*/
}
