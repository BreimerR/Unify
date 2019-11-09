package unify.parsers.expressions

import lib.matcher.TestableStatic
import unify.parsers.ClassInitParser
import language.parsers.AlternativeParser
import unify.parsers.literals.LiteralParser
import unify.parsers.controlstractures.IfParser

class SExpressionParser : AlternativeParser() {
    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
                GroupExpressionParser(),
                InfixExpressionParser(),
                IfParser(),
                ClassInitParser(),
                FunctionCallParser(),
                PreFixExpressionParser(),
                LiteralParser()
        )
        set(value) {}
}