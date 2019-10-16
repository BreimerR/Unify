package unify.parsers.statements

import language.parsers.Parser
import language.sections.Section
import lib.matcher.items.ItemsStatic
import unify.parsers.MethodParser
import unify.tokens.strings.KeywordStatic

class FunctionParser : Parser(
        // function keyword
        Section(KeywordStatic("func"), name = "KEYWORD"),
        // return type
        MethodParser(),
        name = "FUNCTION",
        considerSpaces = false
)
