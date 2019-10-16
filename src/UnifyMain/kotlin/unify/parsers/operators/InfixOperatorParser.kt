package unify.parsers.operators

import language.parsers.Parser
import language.sections.AlternativeSection
import language.sections.Section
import unify.parsers.EqualsToOperatorParser
import unify.tokens.characters.*
import unify.tokens.strings.Identifier


class InfixOperatorParser : Parser(
        AlternativeSection(
                Section(Identifier, name = "INFIX_FUNCTION"),
                ElvisOperatorParser(),
                PlusEqualsOperatorParser(),
                ComparisonOperatorParser(),
                MinusEqualsOperatorParser(),
                AdditionOperatorParser(),
                Section(Minus, name = "MINUS_OPERATOR"),
                Section(GThan, name = "GREATER_THAN_OPERATOR"),
                Section(GThan, name = "LESS_THAN_OPERATOR"),
                SquareOperatorParser(),
                MultiplicationOperatorParser(),
                Section(FSlash, name = "DIVIDE_OPERATOR"),
                Section(Percent, name = "MODULUS_OPERATOR"),
                EqualsToOperatorParser()
        )
)