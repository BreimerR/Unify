package unify.parsers.operators

import language.parsers.Parser
import language.sections.AlternativeSection
import unify.parsers.EqualsToOperatorParser


class ComparisonOperatorParser : Parser(
        AlternativeSection(
                EqualsToOperatorParser(),
                AndOperatorParser(),
                OrOperatorParser()
        )
) {
}