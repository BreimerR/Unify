package unify.parsers.operators

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import unify.parsers.operators.comparison.ComparisonOperatorParser
import unify.parsers.operators.logical.LogicalOperatorParser

class InfixOperatorParser : ParserStatic(
        AlternativeSection(
                ComparisonOperatorParser(),
                LogicalOperatorParser(),
                AssignmentOperatorParser(),
                MathOperatorParser()
        )
){
        override val TAG = "InfixOperatorParser"
}