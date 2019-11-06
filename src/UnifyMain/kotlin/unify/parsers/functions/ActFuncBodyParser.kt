package unify.parsers.functions

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import unify.parsers.expressions.ExpressionParser

class ActFuncBodyParser : ParserStatic() {
    override val sections by lazy {
        arrayOf(
                ActionOperatorParser(),
                AlternativeSection(
                        ExpressionParser()
                )
        )
    }
}