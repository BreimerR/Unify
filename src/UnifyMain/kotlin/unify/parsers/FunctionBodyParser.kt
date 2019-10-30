package unify.parsers

import language.parsers.ParserStatic
import language.sections.OptionalSection
import language.sections.Section
import lib.matcher.TestableStatic
import unify.tokens.characters.LBrace
import unify.tokens.characters.RBrace

class FunctionBodyParser : ParserStatic() {
    override val sections by lazy {
        arrayOf(
                LBrace,
                OptionalSection(
                        FunctionParser()
                ),
                RBrace
        )
    }
}
