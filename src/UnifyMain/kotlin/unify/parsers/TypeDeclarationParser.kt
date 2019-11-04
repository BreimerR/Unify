package unify.parsers

import language.parsers.ParserStatic
import language.sections.OptionalSection
import language.sections.RepetitiveBySection
import language.sections.Section
import language.sections.ZeroOrMany
import unify.tokens.characters.Coma
import unify.tokens.characters.GThan
import unify.tokens.characters.LThan
import unify.tokens.strings.Identifier

class TypeDeclarationParser : ParserStatic() {

    override val sections by lazy {
        arrayOf(
                Identifier,
                OptionalSection(
                        LThan,
                        RepetitiveBySection(
                                TypeDeclarationParser(),
                                Coma
                        ),
                        GThan
                )
        )
    }
}