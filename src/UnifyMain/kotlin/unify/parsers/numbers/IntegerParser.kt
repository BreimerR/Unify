package unify.parsers.numbers

import language.parsers.ParserStatic
import language.sections.Section
import unify.tokens.strings.Number

class IntegerParser : ParserStatic(
        Section(Number)
) {
    override val TAG = "IntegerParser"
}