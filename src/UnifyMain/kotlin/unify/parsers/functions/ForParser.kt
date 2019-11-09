package unify.parsers.functions

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.OptionalSection
import language.sections.RepetitiveBySection
import language.sections.Section
import lib.matcher.TestableStatic
import unify.parsers.VariableDeclarationParser
import unify.parsers.expressions.AssignmentExpressionParser
import unify.parsers.expressions.ExpressionParser
import unify.parsers.literals.ReferenceParser
import unify.tokens.characters.Coma
import unify.tokens.characters.LBracket
import unify.tokens.characters.RBracket
import unify.tokens.characters.SColon
import unify.tokens.strings.IdentifierStatic
import unify.tokens.strings.KeywordStatic

class ForParser : ParserStatic() {

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
                                                ExpressionParser()
                                        )

                                )
                        ),
                        RBracket,
                        FunctionBodyParser()
                )

                mSections!!
            } else mSections!!
        }
        set(value) {
            mSections = value
        }

}
