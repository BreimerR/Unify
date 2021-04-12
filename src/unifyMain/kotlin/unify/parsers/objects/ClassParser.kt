package unify.parsers.objects

import language.parsers.ParserStatic
import language.sections.*
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
                ParametersParser()
            ),
            OptionalSection(
                Section(Colon),
                TypeDeclarationParser(),
                // argument calls should be in a separate place not here
                OptionalSection(
                    LBracket,
                    OptionalSection(
                        RepetitiveBySection(
                            Coma,
                            ExpressionParser()
                        )
                    ),
                    RBracket
                )
            ),
            OptionalSection(
                Section(
                    ReferenceOperatorParser(),
                    RepetitiveBySection(
                        Coma,
                        TypeDeclarationParser()
                    )
                )
            ),
            OptionalSection(
                ClassBodyParser()
            )
        )
        set(value) {}
}