package unify.parsers

import language.parsers.Parser
import lib.matcher.sections.OptionalSection
import lib.matcher.sections.Section
import unify.tokens.characters.Dot
import unify.tokens.strings.Number

class SimpleNumberParser : Parser(
        Section(Number),
        OptionalSection(
                Dot,
                Number
        ),
        name = "SIMPLE_NUMBER"
) {
    override val considerSpaces = true
}