package unify.parsers.operators

import language.parsers.Parser
import language.sections.Section
import unify.tokens.characters.Asterisk

class SquareOperatorParser : Parser(
        Section(Asterisk, Asterisk),
        name = "SQUARE_OPERATOR"
)
