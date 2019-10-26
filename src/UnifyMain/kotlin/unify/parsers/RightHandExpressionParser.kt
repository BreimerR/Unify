package unify.parsers

import language.parsers.Parser
import lib.matcher.sections.AlternativeSection
import unify.parsers.expressions.ExpressionParser


class RightHandExpressionParser : Parser(

        AlternativeSection(
                ExpressionParser(),
                LiteralParser()
        )
) {
}