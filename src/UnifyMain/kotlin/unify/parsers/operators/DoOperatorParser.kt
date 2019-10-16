package unify.parsers.operators

import language.parsers.Parser
import language.sections.Section
import unify.tokens.characters.GThan
import unify.tokens.characters.Minus

class DoOperatorParser : Parser(
        Section(
                Minus,
                GThan
        ),
        name = "DO_OPERATOR"
)