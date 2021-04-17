package unify.parsers.variables

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.OptionalSection
import language.sections.RepetitiveBySection
import language.sections.Section
import lib.matcher.TestableStatic
import unify.parsers.literals.ReferenceParser
import unify.parsers.numbers.IntegerParser
import unify.tokens.characters.*

class VariableTypeDeclarationParser : ParserStatic() {

    override var sections: Array<out TestableStatic<String>>
        get() {
            return arrayOf(
                ReferenceParser(),
                OptionalSection(
                    LThan,
                    RepetitiveBySection(
                        Coma,
                        VariableTypeDeclarationParser()
                    ),
                    GThan
                ),
                OptionalSection(
                    LSBracket,
                    OptionalSection(
                        AlternativeSection(
                            Section(
                                IntegerParser(),
                                Colon,
                                OptionalSection(
                                    IntegerParser()
                                )
                            ),
                            OptionalSection(
                                /**@Description
                                 * Supported array dimensions
                                 * var array:Int[2] // 1D Array
                                 * var array:Int[2,2] // 2D Array
                                 * var array:Int[2,2,2] // 3d Array
                                 * Thus given an Array A of length N we'd have N D array
                                 * var array:Type[...A] // N D Array
                                 * */
                                /**@Description
                                 * Supported array dimensions
                                 * var array:Int[2] // 1D Array
                                 * var array:Int[2,2] // 2D Array
                                 * var array:Int[2,2,2] // 3d Array
                                 * Thus given an Array A of length N we'd have N D array
                                 * var array:Type[...A] // N D Array
                                 * */
                                RepetitiveBySection(
                                    Coma,
                                    IntegerParser()
                                )
                            )
                        )
                    ),
                    RSBracket
                )
            )
        }
        set(value) {}


    override val TAG = "VariableTypeDeclarationParser"
}