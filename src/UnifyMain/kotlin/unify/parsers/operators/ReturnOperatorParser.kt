package unify.parsers.operators

import language.parsers.Parser
import lib.matcher.sections.Section
import unify.tokens.characters.Equals
import unify.tokens.characters.GThan

class ReturnOperatorParser : Parser(
        Section(
                Equals,
                GThan
        ),
        name = "RETURN_OPERATOR"
)