package unify.parsers

import language.parsers.ParserStatic
import unify.parsers.expressions.FunctionCallParser
import unify.parsers.functions.CallParser
import unify.tokens.strings.KeywordStatic

class ClassInitParser : ParserStatic(
        KeywordStatic("new"),
        CallParser()
)