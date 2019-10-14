package unify.parsers.operators

import language.parsers.Parser
import lib.matcher.sections.Section
import unify.tokens.characters.Asterisk

class SquareOperatorParser : Parser(
        Section(Asterisk, Asterisk),
        name = "SQUARE_OPERATOR"
)
