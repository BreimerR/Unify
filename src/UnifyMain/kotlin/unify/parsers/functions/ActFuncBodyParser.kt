package unify.parsers.functions

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import lib.matcher.TestableStatic
import unify.parsers.expressions.TExpressionParser

class ActFuncBodyParser : ParserStatic() {

    override val TAG = "ActFuncBodyParser"

    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
                ActionOperatorParser(),
                AlternativeSection(
                        TExpressionParser(),
                        FunctionItemsParser()
                )
        )
        set(value) {}
}