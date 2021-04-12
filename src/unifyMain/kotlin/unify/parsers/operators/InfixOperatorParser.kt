package unify.parsers.operators

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import unify.parsers.literals.ReferenceParser
import unify.parsers.operators.comparison.ComparisonOperatorParser
import unify.parsers.operators.logical.LogicalOperatorParser

class InfixOperatorParser : ParserStatic(
        AlternativeSection(
                ComparisonOperatorParser(),
                LogicalOperatorParser(),
                // an assignment as an expression is causing issues as it can not be used as an infix expression exactly
                // AssignmentOperatorParser(),
                MathOperatorParser()
        )
) {
    override val TAG = "InfixOperatorParser"
}