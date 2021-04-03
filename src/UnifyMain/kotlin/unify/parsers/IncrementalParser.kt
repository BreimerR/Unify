package unify.parsers

import language.parsers.AlternativeParser
import language.parsers.ParserStatic
import language.sections.Section
import unify.parsers.literals.ReferenceParser
import unify.tokens.characters.Minus
import unify.tokens.characters.Plus

class IncrementalParser : AlternativeParser(
    Section(
        Plus,
        Plus,
        ReferenceParser()
    ),
    Section(
        ReferenceParser(),
        Plus,
        Plus
    )
)