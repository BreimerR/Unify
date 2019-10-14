package unify.parsers.operators

import language.parsers.Parser
import lib.matcher.sections.Section
import unify.tokens.characters.Dot

class BreakDownOperator : Parser(
        Section(
                Dot,
                Dot,
                Dot
        ),
        name = "BREAKDOWN_OPERATOR"
)