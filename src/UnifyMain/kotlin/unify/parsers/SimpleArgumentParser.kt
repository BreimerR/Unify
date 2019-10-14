package unify.parsers

import language.parsers.Parser
import lib.matcher.sections.AlternativeSection
import lib.matcher.sections.OptionalSection
import lib.matcher.sections.Section
import unify.tokens.strings.Identifier
import unify.tokens.strings.KeywordStatic

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
        )
) {
    override val considerSpaces = false
}