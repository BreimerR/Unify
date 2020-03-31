package unify.parsers.expressions

import language.parsers.ParserStatic
import lib.matcher.TestableStatic
import unify.tokens.characters.Colon
import unify.tokens.characters.Question

class ElvisExpressionParser : ParserStatic() {
    override var sections: Array<out TestableStatic<String>>
        get() {
            return arrayOf<TestableStatic<String>>(
                    SExpressionParser(),
                    Question,
                    ExpressionParser(),
                    Colon,
                    ExpressionParser()
            )
        }
        set(value) {}

    override val TAG = "ElvisExpressionParser"

}