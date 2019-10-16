package unify.parsers

import language.parsers.Parser
import language.sections.RepetitiveBySection
import unify.tokens.characters.Dot
import unify.tokens.strings.Identifier

class ReferenceParser : Parser(
        RepetitiveBySection(
                Identifier,
                Dot,
                considerSpaces = true
        ),
        considerSpaces = false
)