package language.parsers

import DEBUG_PARSERS
import language.sections.AlternativeSection
import language.sections.Section
import language.sections.ZeroOrMany
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic
import unify.tokens.characters.NewLine
import unify.tokens.characters.Space
import unify.tokens.characters.Tab
import DEBUG as SYS_DEBUG

abstract class ParserStatic(
    vararg sections: TestableStatic<String>,
    considerSeparation: Boolean = false,
    considerSpaces: Boolean = false,
    considerNewLines: Boolean = false,
    name: String? = null
) : Section(
    *when {
        considerSeparation -> arrayOf(
            ZeroOrMany(
                // consume previous spaces and tabs before next parse test or parse
                AlternativeSection(
                    Tab, Space, NewLine,
                    considerSeparation = true
                )
            ), *sections
        )

        considerSpaces -> arrayOf(
            ZeroOrMany(
                // consume previous spaces and tabs before next parse test or parse
                AlternativeSection(
                    Tab, Space,
                    considerSpaces = true
                )
            ), *sections
        )

        else -> sections
    },
    considerSeparation = considerSeparation,
    considerNewLines = considerNewLines,
    considerSpaces = considerSpaces,
    name = name
) {

    var startIndex: Int = -1

    override val DEBUG
        get() = SYS_DEBUG && DEBUG_PARSERS


    override fun test(items: ItemsStatic.Class<String>): Boolean {

        var test = super.test(items)

        return test
    }

}
