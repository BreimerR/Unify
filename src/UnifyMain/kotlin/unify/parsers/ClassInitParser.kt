package unify.parsers

import language.parsers.ParserStatic
import unify.parsers.expressions.FunctionCallParser
import unify.tokens.strings.KeywordStatic

class ClassInitParser : ParserStatic(
        KeywordStatic("new"),
        FunctionCallParser()
)