package unify.parsers

import language.parsers.ParserStatic
import language.sections.Section
import unify.tokens.strings.Identifier

class SingleArgumentParser : ParserStatic(
        TypeDeclarationParser(),
        Section(Identifier)
) {
}