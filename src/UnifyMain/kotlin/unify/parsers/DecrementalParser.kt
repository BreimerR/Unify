package unify.parsers

import language.parsers.AlternativeParser
import language.parsers.ParserStatic
import language.sections.Section
import unify.parsers.literals.ReferenceParser
import unify.tokens.characters.Minus

class DecrementalParser : AlternativeParser(
    Section(
        Minus,
        Minus,
        ReferenceParser()
    ),
    Section(
        ReferenceParser(),
        Minus,
        Minus
    )
)