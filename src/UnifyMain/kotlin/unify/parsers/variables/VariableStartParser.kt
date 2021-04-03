package unify.parsers.variables

import language.parsers.ParserStatic
import language.sections.*
import lib.matcher.TestableStatic
import unify.parsers.ReferenceOperatorParser
import unify.parsers.TypeDeclarationParser
import unify.parsers.expressions.ExpressionParser
import unify.parsers.literals.ReferenceParser
import unify.parsers.numbers.IntegerParser
import unify.tokens.characters.*
import unify.tokens.strings.Identifier

class VariableStartParser : ParserStatic() {

    override val TAG = "VariableStartParser"

    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
            // TODO should be a reference not necessarily an identifier
            Section(Identifier, name = "VAR_NAME"),
            OptionalSection(
                Colon,
                TypeDeclarationParser()
            ),
            OptionalSection(
                LSBracket,
                OptionalSection(
                    // Does not cater for matrix arrays
                    // This should define the shape of the array i.e
                    // var matrix:Integer{2,2}
                    RepetitiveBySectionReMaster(
                        Coma,
                        IntegerParser()
                    )
                ),
                RSBracket
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
