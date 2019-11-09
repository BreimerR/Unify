package unify.parsers.expressions

import lib.matcher.TestableStatic
import language.parsers.ParserStatic
import unify.parsers.literals.LiteralParser
import unify.parsers.operators.InfixOperatorParser

class InfixExpressionParser : ParserStatic() {

    override var sections: Array<out TestableStatic<String>>
        get() {
            return arrayOf(
                    LiteralParser(),
                    InfixOperatorParser(),
                    ExpressionParser()
            )
        }
        set(value) {}
}