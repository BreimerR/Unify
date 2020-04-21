package unify.parsers.objects

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.OptionalSection
import language.sections.RepetitiveBySection
import language.sections.Section
import lib.matcher.TestableStatic
import unify.parsers.*
import unify.parsers.expressions.ExpressionParser
import unify.tokens.characters.Colon
import unify.tokens.characters.Coma
import unify.tokens.characters.LBracket
import unify.tokens.characters.RBracket
import unify.tokens.strings.Identifier
import unify.tokens.strings.KeywordStatic

class ClassParser : ParserStatic() {

    override val TAG = "ClassParser"

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
                                GenericTypeParser(),
                                name = "GENERIC_TYPES"
                        )
                ),
                OptionalSection(
                        ArgumentsParser()
                ),
                OptionalSection(
                        Section(Colon),
                        TypeDeclarationParser(),
                        // argument calls should be in a separate place not here
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