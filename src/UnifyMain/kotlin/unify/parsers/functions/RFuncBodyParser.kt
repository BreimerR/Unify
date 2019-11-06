package unify.parsers.functions

import language.parsers.AlternativeParser
import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.Section
import unify.parsers.expressions.ExpressionParser

class RFuncBodyParser : AlternativeParser() {
    override val sections by lazy {
        arrayOf(
                RFuncItemsParser(),
                Section(
                        ReturnActionOperatorParser(),
                        AlternativeSection(
                                ExpressionParser(),
                                RFuncItemsParser()
                        )
                ),
                Section(
                        ActionOperatorParser(),
                        AlternativeSection(
                                ExpressionParser()
                        )
                )
        )
    }
}