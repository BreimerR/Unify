package unify.parsers.expressions

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import lib.matcher.TestableStatic
import unify.parsers.ClassInitParser
import unify.parsers.controlstractures.IfParser
import unify.parsers.literals.LiteralParser

class SExpressionParser : ParserStatic() {
    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
                AlternativeSection(
                        GroupExpressionParser(),
                        InfixExpressionParser(),
                        FunctionCallParser(),
                        IfParser(),
                        ClassInitParser(),
                        // PreFixExpressionParser(),
                        LiteralParser()
                )
        )
        set(value) {}

    override val TAG = "SExpressionParser"

}