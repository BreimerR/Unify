package unify.parsers.controlstractures

import language.parsers.ParserStatic
import language.sections.*
import lib.matcher.TestableStatic
import unify.parsers.expressions.AssignmentExpressionParser
import unify.parsers.expressions.ExpressionParser
import unify.parsers.literals.ReferenceParser
import unify.parsers.variables.VariableDeclarationParser
import unify.tokens.characters.Coma
import unify.tokens.characters.LBracket
import unify.tokens.characters.RBracket
import unify.tokens.characters.SColon
import unify.tokens.strings.IdentifierStatic
import unify.tokens.strings.KeywordStatic

class ForParser : ParserStatic(name = "FOR_LOOP") {

    override val TAG = "ForParser"

    var mSections: Array<out TestableStatic<String>>? = null


    override var sections: Array<out TestableStatic<String>>
        get() {
            return if (mSections == null) {
                mSections = arrayOf(
                    KeywordStatic("for"),
                    LBracket,
                    /** TODO
                     * return should not break if for is to be used as a return
                     * if for used as a return then item is assigned multiple times
                     * var age = for(i in 0..10){
                     *      i += 1
                     * }
                     *
                     * println(age)
                     *
                     * @results
                     * 10
                     *
                     * */
                    AlternativeSection(
                        Section(
                            VariableDeclarationParser(),
                            IdentifierStatic("in"),
                            ReferenceParser()
                        ),
                        Section(
                            OptionalSection(
                                RepetitiveBySection(
                                    Coma,
                                    AssignmentExpressionParser()
                                ),
                                SColon
                            ),
                            ExpressionParser(),
                            OptionalSection(
                                SColon,
                                RepetitiveBySection(
                                    Coma,
                                    AlternativeSection(
                                        AssignmentExpressionParser(),
                                        ExpressionParser()
                                    )
                                )
                            )
                        )
                    ),
                    RBracket,
                    AlternativeSection(
                        ExpressionParser(),
                        ForBodyParser()
                    )
                )

                mSections!!
            } else mSections!!
        }
        set(value) {
            mSections = value
        }

}
