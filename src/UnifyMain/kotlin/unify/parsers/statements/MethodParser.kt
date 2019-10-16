package unify.parsers

import language.parsers.Parser
import language.sections.AlternativeSection
import language.sections.OptionalSection
import language.sections.Section
import unify.tokens.strings.Identifier

class MethodParser : Parser(
        AlternativeSection(
                Section(
                        TypeDeclarationParser(),
                        Section(Identifier,
                                name = "name"),
                        considerSpaces = false
                ),
                Section(Identifier, name = "name")
        ),
        // ARGUMENTS
        OptionalSection(
                ArgumentsParser(),
                name = "ARGUMENTS",
                considerSpaces = false
        ),
        // FUNCTION BODY
        FunctionBodyParser(),
        name = "METHOD"
) {
}