package unify.parsers.operators

import language.parsers.Parser
import language.sections.Section
import unify.tokens.characters.Colon
import unify.tokens.characters.Question

class ElvisOperatorParser : Parser(
        Section(
                Colon,
                Question
        ),
        name = "ELVIS_OPERATOR"
)