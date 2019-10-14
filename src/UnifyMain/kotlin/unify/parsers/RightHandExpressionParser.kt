package unify.parsers

import language.parsers.Parser
import lib.matcher.sections.AlternativeSection
import unify.parsers.operators.InfixOperatorParser

class RightHandExpressionParser : Parser(
        InfixOperatorParser(),
        AlternativeSection(
                ExpressionParser(),
                LiteralParser()
        )
) {
}