package unify.parsers.variables

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.OptionalSection
import language.sections.RepetitiveBySection
import language.sections.Section
import lib.matcher.TestableStatic
import unify.parsers.ReferenceOperatorParser
import unify.parsers.TypeDeclarationParser
import unify.parsers.expressions.ExpressionParser
import unify.parsers.literals.ReferenceParser
import unify.tokens.characters.Colon
import unify.tokens.characters.Coma
import unify.tokens.characters.Dollar
import unify.tokens.strings.Identifier

class VariableStartParser : ParserStatic() {

    override val TAG = "VariableStartParser"

    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
                Section(Identifier, name = "VAR_NAME"),
                OptionalSection(
                        Colon,
                        TypeDeclarationParser()
                ),
                OptionalSection(
                        DestructuringParser()
                ),
                OptionalSection(
                        ReferenceOperatorParser(),
                        AlternativeSection(
                                Section(
                                        ExpressionParser(),
                                        RepetitiveBySection(
                                                Dollar,
                                                ReferenceParser(),
                                                Coma
                                        )
                                ),
                                ExpressionParser(),
                                RepetitiveBySection(
                                        Dollar,
                                        ReferenceParser(),
                                        Coma
                                )

                        )
                )
        )
        set(value) {}
}