package unify.parsers

import language.parsers.Parser
import language.sections.AlternativeSection
import unify.parsers.expressions.ExpressionParser
import unify.parsers.operators.InfixOperatorParser

class RightHandExpressionParser : Parser(
        InfixOperatorParser(),
        AlternativeSection(
                ExpressionParser(),
                LiteralParser()
        )
) {
}