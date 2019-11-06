package unify.parsers.expressions

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import unify.parsers.literals.LiteralParser
import unify.parsers.operators.InfixOperatorParser

class InfixExpressionParser : ParserStatic(

) {
    override val sections by lazy {
        arrayOf(
                AlternativeSection(
                        LiteralParser(),
                        FunctionCallParser()
                ),
                InfixOperatorParser(),
                ExpressionParser()

        )
    }
}