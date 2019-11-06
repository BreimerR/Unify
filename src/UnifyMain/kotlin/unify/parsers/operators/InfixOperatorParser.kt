package unify.parsers.operators

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.Section
import unify.parsers.operators.comparison.ComparisonOperatorParser
import unify.tokens.strings.Identifier

class InfixOperatorParser : ParserStatic(
        AlternativeSection(
                AssignmentOperatorParser(),
                ComparisonOperatorParser(),
                Section(Identifier),
                MathOperatorParser()
        )
)