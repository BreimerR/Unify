package unify.parsers.controlstractures

import language.parsers.ParserStatic
import language.sections.*
import unify.parsers.expressions.ExpressionParser
import unify.parsers.functions.FunctionBodyParser
import unify.tokens.strings.KeywordStatic

class IfParser : ParserStatic(
        KeywordStatic("if"),
        ExpressionParser(),
        RepetitiveBySection(
                Section(
                        KeywordStatic("else"),
                        KeywordStatic("if"),
                        ExpressionParser()
                ),
                FunctionBodyParser()
        ),
        OptionalSection(
                KeywordStatic("else"),
                AlternativeSection(
                        FunctionBodyParser(),
                        ExpressionParser()
                )
        ),
        name = "IF_STATEMENT"
) {
    override val TAG: String
        get() = "IfParser"
}


