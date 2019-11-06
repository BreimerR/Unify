package unify.parsers.literals

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.OptionalSection
import language.sections.Section
import language.sections.ZeroOrMany
import unify.parsers.expressions.SimpleNumberParser
import unify.tokens.characters.NewLine
import unify.tokens.characters.Space
import unify.tokens.characters.Tab
import unify.tokens.strings.Identifier

class NumberParser : ParserStatic(
        SimpleNumberParser(),
        OptionalSection(
                AlternativeSection(
                        Section(
                                Identifier, SimpleNumberParser()
                        ),
                        Identifier,
                        considerSeparation = true
                )
        )
)