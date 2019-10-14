package unify.parsers.operators

import language.parsers.Parser
import lib.matcher.sections.Section
import unify.tokens.characters.Asterisk
import unify.tokens.characters.Equals

class TimesEqualsOperatorParser : Parser(
        Section(
                Asterisk,
                Equals
        ),
        name = "TIMES_EQUALS_OPERATOR"
)