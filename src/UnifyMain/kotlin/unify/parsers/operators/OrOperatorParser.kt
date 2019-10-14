package unify.parsers.operators

import language.parsers.Parser
import lib.matcher.sections.Section
import unify.tokens.characters.Pipe

class OrOperatorParser : Parser(
        Section(
                Pipe,
                Pipe
        ),
        name = "OR_OPERATOR"
)