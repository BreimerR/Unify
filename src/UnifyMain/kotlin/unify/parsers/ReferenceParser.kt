package unify.parsers

import language.parsers.Parser
import lib.matcher.sections.RepetitiveBySection
import unify.tokens.characters.Dot
import unify.tokens.strings.Identifier

class ReferenceParser : Parser(
        RepetitiveBySection(
                Identifier,
                Dot
        )
)