package unify.parsers

import language.parsers.Parser
import lib.matcher.sections.AlternativeSection
import lib.matcher.sections.OptionalSection
import lib.matcher.sections.Section
import unify.tokens.strings.Identifier

class MethodParser : Parser(
        AlternativeSection(
                Section(
                        TypeDeclarationParser(),
                        Section(Identifier, name = "name")
                ),
                Section(Identifier, name = "name")
        ),
        // ARGUMENTS
        OptionalSection(ArgumentsParser(), name = "ARGUMENTS"),
        // FUNCTION BODY
        FunctionBodyParser(),
        name = "METHOD"
) {
}