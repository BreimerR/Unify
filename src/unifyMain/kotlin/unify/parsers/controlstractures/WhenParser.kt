package unify.parsers.controlstractures

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.OptionalSection
import unify.parsers.expressions.ExpressionParser
import unify.parsers.literals.ReferenceParser
import unify.parsers.operators.InfixOperatorParser
import unify.tokens.strings.KeywordStatic

class WhenParser : ParserStatic(
        KeywordStatic("when"),
        ExpressionParser(),
        OptionalSection(
                AlternativeSection(
                        InfixOperatorParser(),
                        // Reference is not an infix operator for security some reason but look into making it one
                        ReferenceParser()
                )
        ),
        CaseBodyParser()
) {
    override val TAG = "WhenParser"
}