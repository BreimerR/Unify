package unify.parsers

import language.parsers.Parser
import language.sections.OptionalSection
import language.sections.Section
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