package unify.parsers.controlstractures

import language.parsers.ParserStatic
import language.sections.OptionalSection
import unify.parsers.expressions.ExpressionParser
import unify.parsers.operators.InfixOperatorParser
import unify.tokens.strings.KeywordStatic

class WhenParser : ParserStatic(
        KeywordStatic("when"),
        ExpressionParser(),
        OptionalSection(
                InfixOperatorParser()
        ),
        CaseBodyParser()
) {
        override val TAG = "WhenParser"
}