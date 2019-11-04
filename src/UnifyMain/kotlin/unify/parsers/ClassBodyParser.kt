package unify.parsers

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.ZeroOrMany
import unify.functions.MethodParser
import unify.tokens.characters.LBrace
import unify.tokens.characters.RBrace

class ClassBodyParser : ParserStatic() {
    override val sections by lazy {
        arrayOf(
                LBrace,
                ZeroOrMany(
                        AlternativeSection(
                                ClassParser(),
                                MethodParser()
                        )
                ),
                RBrace
        )
    }
}
