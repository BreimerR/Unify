package unify.parsers.expressions

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import lib.matcher.TestableStatic
import unify.parsers.ClassInitParser
import unify.parsers.controlstractures.IfParser
import unify.parsers.literals.LiteralParser

class ExpressionParser : ParserStatic() {
    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
                AlternativeSection(
                        SExpressionParser(),
                        ElvisExpressionParser()
                )
        )
        set(value) {}
}