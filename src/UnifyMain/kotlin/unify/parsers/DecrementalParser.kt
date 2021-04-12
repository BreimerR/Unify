package unify.parsers

import language.parsers.AlternativeParser
import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.Section
import language.sections.ZeroOrMany
import unify.parsers.literals.ReferenceParser
import unify.tokens.characters.Minus
import unify.tokens.characters.NewLine
import unify.tokens.characters.Space
import unify.tokens.characters.Tab

class DecrementalParser : AlternativeParser(
    Section(
        ZeroOrMany(
            AlternativeSection(
                Tab,
                Space,
                NewLine,
                considerSeparation = true
            )
        ),
        Minus,
        Minus,
        // TODO this is required to prevent --\nIdentifier
        // ReferenceParser(considerNewLines=true),
        considerSeparation = true
    ),
    Section(
        ReferenceParser(),
        Minus,
        Minus,
        considerSeparation = true
    )
)