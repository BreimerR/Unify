package unify.parsers.operators

import language.parsers.Parser
import language.sections.Section

import unify.tokens.characters.Plus

class AdditionOperatorParser : Parser(
        Section(Plus),
        name = "PLUS_OPERATOR"
)
