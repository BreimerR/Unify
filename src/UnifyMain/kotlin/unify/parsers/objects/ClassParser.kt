package unify.parsers

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.OptionalSection
import language.sections.RepetitiveBySection
import language.sections.Section
import unify.tokens.characters.Colon
import unify.tokens.characters.Coma
import unify.tokens.strings.KeywordStatic

class ClassParser : ParserStatic() {
    override val sections by lazy {
        arrayOf(
                OptionalSection(
                        AlternativeSection(
                                KeywordStatic("abstract"),
                                KeywordStatic("data")
                        )
                ),
                KeywordStatic("class"),
                TypeDeclarationParser(),
                OptionalSection(
                        Section(Colon),
                        TypeDeclarationParser()
                ),
                OptionalSection(
                        Section(
                                ReferenceOperatorParser(),
                                RepetitiveBySection(
                                        TypeDeclarationParser(),
                                        Coma
                                )
                        )
                ),
                OptionalSection(
                        ClassBodyParser()
                )
        )
    }
}