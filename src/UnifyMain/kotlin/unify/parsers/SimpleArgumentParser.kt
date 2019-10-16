package unify.parsers

import language.parsers.Parser
import language.sections.AlternativeSection
import language.sections.OptionalSection
import language.sections.Section
import unify.tokens.strings.Identifier

class SimpleArgumentParser : Parser(
        OptionalSection(
                MutabilityStateParser()
        ),
        AlternativeSection(
                Section(
                        OptionalSection(
                                TypeDeclarationParser(),
                                name = "TYPE"
                        ),
                        Section(Identifier, name = "NAME")
                ),
                Section(Identifier, name = "NAME")
        ),
        considerSpaces = false
)