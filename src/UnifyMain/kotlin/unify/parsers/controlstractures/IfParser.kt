package unify.parsers.controlstractures

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.OptionalSection
import language.sections.RepetitiveBySection
import language.sections.Section
import unify.tokens.strings.KeywordStatic
import unify.parsers.expressions.ExpressionParser
import unify.parsers.functions.FunctionBodyParser

class IfParser : ParserStatic(
        KeywordStatic("if"),
        ExpressionParser(),
        OptionalSection(
                RepetitiveBySection(
                        FunctionBodyParser(),
                        Section(
                                KeywordStatic("else"),
                                KeywordStatic("if"),
                                ExpressionParser()
                        )
                )
        ),
        OptionalSection(
                KeywordStatic("else"),
                AlternativeSection(
                        ExpressionParser(),
                        FunctionBodyParser()
                )
        )
)