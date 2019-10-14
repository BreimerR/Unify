package unify.parsers

import language.parsers.Parser
import lib.matcher.sections.Section
import unify.tokens.characters.Equals
import unify.tokens.characters.Exclamation

class NotEqualOperatorParser : Parser(
        Section(
                Exclamation,
                Equals
        ),
        name = "NOT_EQUALS_OPERATOR"
)