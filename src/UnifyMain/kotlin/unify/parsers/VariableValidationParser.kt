package unify.parsers

import language.parsers.Parser
import lib.matcher.sections.AlternativeSection
import lib.matcher.sections.Section
import unify.parsers.operators.DColonOperatorParser
import unify.tokens.strings.Identifier

class VariableValidationParser : Parser(
        Section(
                DColonOperatorParser(),
                name = "START"
        ),
        AlternativeSection(
                RightHandExpressionParser(),
                Section(
                        Identifier,
                        name = "FUNCTION_NAME_REFERENCE"
                )
        )
) {
}