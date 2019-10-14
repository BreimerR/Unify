package unify.parsers.expressions

import language.parsers.Parser
import lib.matcher.sections.AlternativeSection
import unify.parsers.NumberParser
import unify.parsers.ReferenceParser

class ExpressionParser : Parser(
        AlternativeSection(
                NumberParser(),
                ReferenceParser()
        ),
        name = "EXPRESSION"
) {
}