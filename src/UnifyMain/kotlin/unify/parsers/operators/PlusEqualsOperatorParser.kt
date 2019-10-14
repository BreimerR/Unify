package unify.parsers.operators

import language.parsers.Parser
import lib.matcher.sections.Section
import unify.tokens.characters.Equals
import unify.tokens.characters.Plus

class PlusEqualsOperatorParser : Parser(
        Section(Plus,Equals),
        name = "PLUS_EQUALS_OPERATOR"
)
