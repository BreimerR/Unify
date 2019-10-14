package unify.parsers

import language.parsers.Parser
import lib.matcher.sections.AlternativeSection
import lib.matcher.sections.OptionalSection
import lib.matcher.sections.Section
import unify.tokens.characters.Colon
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