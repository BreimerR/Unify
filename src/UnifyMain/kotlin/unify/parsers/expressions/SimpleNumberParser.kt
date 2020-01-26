package unify.parsers.expressions

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.OptionalSection
import language.sections.Section
import unify.tokens.characters.Dot
import unify.tokens.characters.Minus
import unify.tokens.characters.Plus
import unify.tokens.strings.Number

class SimpleNumberParser : ParserStatic(
        OptionalSection(
                AlternativeSection(
                        Plus,
                        Minus
                )
        ),
        Section(Number, OptionalSection(Dot, Number))
)