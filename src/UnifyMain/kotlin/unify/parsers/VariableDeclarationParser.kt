package unify.parsers

import language.parsers.Parser
import language.sections.OptionalSection
import lib.matcher.sections.Section
import unify.tokens.strings.Identifier

class VariableDeclarationParser : Parser(
        OptionalSection(
                TypeDeclarationParser(),
                name = "TYPE"
        ),
        Section(Identifier, name = "NAME")
)


