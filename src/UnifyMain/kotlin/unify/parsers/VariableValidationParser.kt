package unify.parsers

import language.parsers.Parser
import language.sections.AlternativeSection
import language.sections.Section
import unify.parsers.operators.DColonOperatorParser
import unify.tokens.strings.Identifier

class VariableValidationParser : Parser(
        Section(
                DColonOperatorParser(),
                name = "START",
                considerSpaces = false
        ),
        AlternativeSection(
                RightHandExpressionParser(),
                Section(
                        Identifier,
                        name = "FUNCTION_NAME_REFERENCE",
                        considerSpaces = false
                )
        ),
        considerSpaces = false
)