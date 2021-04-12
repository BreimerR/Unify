package unify.parsers.expressions

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import lib.matcher.TestableStatic
import unify.parsers.functions.LambdaBodyParser
import unify.tokens.characters.Colon
import unify.tokens.characters.Question

class ElvisExpressionParser : ParserStatic() {
    override var sections: Array<out TestableStatic<String>>
        get() {
            return arrayOf(
                    SExpressionParser(),
                    Question,
                    AlternativeSection(
                            ExpressionParser(),
                            LambdaBodyParser()
                    ),
                    Colon,
                    AlternativeSection(
                            ExpressionParser(),
                            LambdaBodyParser()
                    )
            )
        }
        set(value) {}

    override val TAG = "ElvisExpressionParser"

}