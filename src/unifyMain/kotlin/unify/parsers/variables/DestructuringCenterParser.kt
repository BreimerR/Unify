package unify.parsers.variables

import language.parsers.ParserStatic
import language.sections.*
import lib.matcher.TestableStatic
import unify.tokens.characters.Coma
import unify.tokens.characters.Dot

class DestructuringCenterParser : ParserStatic() {

    override val TAG = "DestructuringCenterParser"

    override var sections: Array<out TestableStatic<String>>
        get() {


            val dotVariable = Section(
                Dot,
                Dot,
                Dot,
                SimpleVariableParser(),
                considerNewLines = true
            )

            val repetitiveBy = RepetitiveBySection(
                Coma,
                OptionalMutabilityVariableDeclarationParser()
            )

            return arrayOf(
                AlternativeSection(
                    Section(
                        RepetitiveSection(
                            OptionalMutabilityVariableDeclarationParser(),
                            Coma
                        ),
                        dotVariable
                    ),
                    Section(
                        dotVariable,
                        Coma,
                        repetitiveBy
                    ),
                    repetitiveBy
                )
            )
        }
        set(value) {}
}