package unify.parsers

import language.parsers.Parser
import language.sections.AlternativeSection
import language.sections.OptionalSection
import lib.matcher.sections.Section
import unify.tokens.strings.Identifier

class BareVariableDeclarationParser : Parser(
        AlternativeSection(
                Section(
                        // variable type
                        TypeDeclarationParser(),
                        // variable name
                        Section(Identifier, name = "NAME")
                ),
                Section(Identifier, name = "NAME")
        ),
        // variable default value
        OptionalSection(
                DefaultValueParser()
        ),
        // variable validation
        OptionalSection(
                VariableValidationParser()
        )
) {
}