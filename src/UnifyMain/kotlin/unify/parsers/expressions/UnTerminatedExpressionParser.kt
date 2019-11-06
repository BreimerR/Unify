package unify.parsers.expressions

import language.sections.Section
import unify.tokens.characters.Colon
import unify.tokens.characters.Question
import language.parsers.AlternativeParser
import language.sections.AlternativeSection

class UnTerminatedExpressionParser : AlternativeParser() {

    override val sections by lazy {
        arrayOf(
                AlternativeSection(
                        GroupExpressionParser(),
                        // PreFixExpressionParser(),
                        Section(
                                NativeExpressionParser(),
                                Question,
                                NativeExpressionParser(),
                                Colon,
                                NativeExpressionParser()
                        ),
                        NativeExpressionParser()
                )
        )
    }
}