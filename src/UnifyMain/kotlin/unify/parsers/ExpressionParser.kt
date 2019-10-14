package unify.parsers

import language.parsers.Parser
import lib.matcher.sections.AlternativeSection
import unify.tokens.strings.Identifier

class ExpressionParser : Parser(
        AlternativeSection(
                NumberParser(),
                Identifier
        ),
        name = "EXPRESSION"
) {
}