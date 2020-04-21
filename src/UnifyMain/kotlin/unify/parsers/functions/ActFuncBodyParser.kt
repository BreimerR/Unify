package unify.parsers.functions

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import lib.matcher.TestableStatic
import unify.parsers.expressions.ExpressionParser

class ActFuncBodyParser : ParserStatic() {

    override val TAG = "ActFuncBodyParser"

    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
                ActionOperatorParser(),
                AlternativeSection(
                        // terminating this causes issues in if expression parser
                        // could be separated but prefix expressions were removed due to
                        // complexity in break down and visual presentation without additive properities
                        //
                        ExpressionParser(),
                        FunctionItemsParser()
                )
        )
        set(value) {}
}