package unify.parsers.controlstractures

import language.parsers.ParserStatic
import language.sections.*
import lib.matcher.TestableStatic
import unify.parsers.comments.CommentsParser
import unify.parsers.expressions.*
import unify.parsers.functions.ActFuncBodyParser
import unify.parsers.functions.FunctionBodyParser
import unify.parsers.functions.FunctionParser
import unify.parsers.functions.ReturnFuncBodyParser
import unify.parsers.literals.ReferenceParser
import unify.parsers.variables.TVariableDeclarationParser
import unify.parsers.variables.VariableDeclarationParser
import unify.tokens.characters.*
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
                                    AssignmentExpressionParser(),
                                    Coma
                                ),
                                SColon
                            ),
                            ExpressionParser(),
                            OptionalSection(
                                SColon,
                                RepetitiveBySection(
                                    AssignmentExpressionParser(),
                                    Coma
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
