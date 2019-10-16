package unify.parsers

import language.parsers.Parser
import language.sections.Section
import unify.parsers.expressions.ExpressionParser
import unify.tokens.characters.Colon

class DefaultValueParser : Parser(
        Section(
                Colon,
                ExpressionParser()
        ),
        name = "DEFAULT_VALUE"
) {
}