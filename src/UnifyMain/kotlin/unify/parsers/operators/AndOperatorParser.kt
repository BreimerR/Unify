package unify.parsers.operators

import language.parsers.Parser
import language.sections.Section

import unify.tokens.characters.Ampersand

class AndOperatorParser : Parser(
        Section(Ampersand, Ampersand),
        name = "AND_OPERATOR"
)