package unify.parsers.functions

import language.parsers.AlternativeParser
import language.sections.AlternativeSection
import language.sections.Section
import lib.matcher.TestableStatic
import unify.parsers.expressions.TExpressionParser

class RFuncBodyParser : AlternativeParser() {
    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
                RFuncItemsParser(),
                Section(
                        ReturnActionOperatorParser(),
                        AlternativeSection(
                                TExpressionParser(),
                                RFuncItemsParser()
                        )
                ),
                Section(
                        ActionOperatorParser(),
                        AlternativeSection(
                                TExpressionParser()
                        )
                )
        )
        set(value) {}
}