package unify.parsers.expressions

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import lib.matcher.TestableStatic
import unify.parsers.ClassInitParser
import unify.parsers.controlstractures.IfParser
import unify.parsers.literals.LiteralParser

class SExpressionParser : ParserStatic(considerNewLines = true) {
    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
                AlternativeSection(
                        InfixExpressionParser(),
                        FunctionCallParser(),
                        // this is supposed to be a return if statement
                        IfParser(),
                        ClassInitParser(),
                        // PreFixExpressionParser(),
                        LiteralParser(),
                        GroupExpressionParser(),
                        considerNewLine = true
                )
        )
        set(value) {}

    override val TAG = "SExpressionParser"

}