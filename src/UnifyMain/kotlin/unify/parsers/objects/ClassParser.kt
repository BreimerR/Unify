package unify.parsers.objects

import unify.parsers.*
import language.sections.Section
import lib.matcher.TestableStatic
import unify.tokens.characters.Coma
import language.parsers.ParserStatic
import unify.tokens.characters.Colon
import unify.tokens.strings.Identifier
import language.sections.OptionalSection
import unify.tokens.strings.KeywordStatic
import language.sections.AlternativeSection
import language.sections.RepetitiveBySection
import unify.parsers.expressions.ExpressionParser
import unify.tokens.characters.LBracket
import unify.tokens.characters.RBracket

class ClassParser : ParserStatic() {

    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
                OptionalSection(
                        AlternativeSection(
                                KeywordStatic("abstract"),
                                KeywordStatic("data")
                        )
                ),
                KeywordStatic("class"),
                Section(
                        Section(Identifier, name = "NAME"),
                        OptionalSection(
                                GenericTypeParser()
                        )
                ),
                OptionalSection(
                        ArgumentsParser()
                ),
                OptionalSection(
                        Section(Colon),
                        TypeDeclarationParser(),
                        OptionalSection(
                                LBracket,
                                OptionalSection(
                                        RepetitiveBySection(
                                                ExpressionParser(),
                                                Coma
                                        )
                                ),
                                RBracket
                        )
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
        set(value) {}
}