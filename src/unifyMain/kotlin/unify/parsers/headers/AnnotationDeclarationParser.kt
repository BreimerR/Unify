package unify.parsers.headers

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.OptionalSection
import language.sections.RepetitiveBySection
import language.sections.Section
import lib.matcher.TestableStatic
import unify.parsers.*
import unify.parsers.expressions.ExpressionParser
import unify.parsers.objects.ClassParser
import unify.tokens.characters.Colon
import unify.tokens.characters.Coma
import unify.tokens.characters.LBracket
import unify.tokens.characters.RBracket
import unify.tokens.strings.Identifier
import unify.tokens.strings.KeywordStatic

class AnnotationDeclarationParser : ParserStatic() {

    override val TAG = "AnnotationDeclarationParser"

    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
            KeywordStatic("annotation"),
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
                // :
                Section(Colon),
                // Type<Smile>
                TypeDeclarationParser(),
                // argument calls should be in a separate place not here
                // Type<Smile>() if the class has a super call
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