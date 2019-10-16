package unify.parsers

import language.parsers.Parser
import unify.tokens.strings.Identifier
import unify.tokens.strings.KeywordStatic
import language.sections.OptionalSection
import language.sections.AlternativeSection


class NumberParser : Parser(
        SimpleNumberParser(),
        OptionalSection(
                Identifier,
                SimpleNumberParser()
        ),
        OptionalSection(
                AlternativeSection(
                        KeywordStatic("gb"),
                        KeywordStatic("mb"),
                        KeywordStatic("kb"),
                        KeywordStatic("bytes"),
                        KeywordStatic("f"),
                        // double
                        KeywordStatic("d"),
                        // decimal
                        KeywordStatic("D")
                )
        ),
        name = "NUMBER_PARSER"
) {
    override val considerSpaces = false
}