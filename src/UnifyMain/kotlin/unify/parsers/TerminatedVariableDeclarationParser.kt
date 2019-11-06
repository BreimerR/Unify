package unify.parsers

import unify.tokens.characters.SColon
import language.parsers.ParserStatic
import language.sections.OptionalSection

class TerminatedVariableDeclarationParser : ParserStatic(
        VariableDeclarationParser(),
        OptionalSection(
                SColon
        )
) {
}