package unify.parsers

import language.parsers.AlternativeParser
import language.parsers.ParserStatic
import language.sections.Section
import unify.parsers.literals.ReferenceParser
import unify.tokens.characters.Minus
import unify.tokens.characters.Plus
import unify.tokens.strings.Identifier

class IncrementalParser : AlternativeParser(
    Section(
        Plus,
        Plus,
        ReferenceParser(),
        considerSeparation = true,
        considerNewLines = true,
        considerSpaces = true,
        name = "AddBef"
    ),
    Section(
        ReferenceParser(),
        Plus,
        Plus,
        considerSeparation = true,
        considerNewLines = true,
        considerSpaces = true,
        name = "AddAfter"
    ),
    considerNewLine = true
)