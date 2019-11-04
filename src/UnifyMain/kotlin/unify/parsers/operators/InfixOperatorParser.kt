package unify.parsers.operators

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import unify.parsers.operators.comparison.ComparisonOperatorParser

class InfixOperatorParser : ParserStatic(
        AlternativeSection(
                ComparisonOperatorParser()
        )
)