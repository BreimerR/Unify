package unify.parsers.literals

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.OptionalSection
import language.sections.Section
import unify.parsers.expressions.SimpleNumberParser
import unify.tokens.strings.Identifier

class NumberParser : ParserStatic(
        SimpleNumberParser(),
        OptionalSection(
                AlternativeSection(
                        Section(
                                Identifier,
                                SimpleNumberParser(),
                                considerSpaces = true
                        ),
                        Section(
                                Identifier,
                                considerSpaces = true
                        )
                )
        )
) {
    override val TAG = "NumberParser"
}