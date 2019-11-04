package unify.parsers.expressions

import language.parsers.ParserStatic
import language.sections.Section
import lib.matcher.TestableStatic
import unify.parsers.operators.InfixOperatorParser

class ExpressionParser : ParserStatic() {
    override val sections by lazy {
        arrayOf(
                LiteralParser(),
                InfixOperatorParser(),
                ExpressionParser()
        )
    }
}