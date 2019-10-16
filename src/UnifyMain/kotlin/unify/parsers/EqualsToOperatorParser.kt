package unify.parsers

import language.parsers.Parser
import language.sections.Section
import unify.tokens.characters.Equals

class EqualsToOperatorParser : Parser(
        Section(
                Equals,
                Equals
        ),
        name = "EQUALS_TO_OPERATOR"
)