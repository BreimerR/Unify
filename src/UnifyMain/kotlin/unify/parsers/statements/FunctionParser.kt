package unify.parsers

import language.parsers.Parser
import lib.matcher.sections.AlternativeSection
import lib.matcher.sections.Section
import unify.tokens.strings.Identifier
import unify.tokens.strings.KeywordStatic

class FunctionParser : Parser(
        // function keyword
        Section(KeywordStatic("func"), name = "KEYWORD"),
        // return type
        MethodParser(),
        name = "FUNCTION"
) {
    override val considerSpaces = false
}
