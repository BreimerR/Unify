package unify.parsers

import language.parsers.ParserStatic
import language.sections.Section
import lib.matcher.TestableStatic
import unify.tokens.strings.Identifier

class TypeDeclarationParser : ParserStatic() {

    override val sections by lazy {
        arrayOf(
                Identifier
        )
    }
}