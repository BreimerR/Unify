package unify.parsers

import language.parsers.AlternativeParser
import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.Section
import language.sections.ZeroOrMany
import unify.parsers.literals.ReferenceParser
import unify.tokens.characters.*
import unify.tokens.strings.Identifier

class IncrementalParser : AlternativeParser(
    Section(
        ZeroOrMany(
            AlternativeSection(
                Tab,
                Space,
                NewLine,
                considerSeparation = true
            )
        ),
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