package unify.parsers.functions

import language.parsers.ParserStatic
import unify.tokens.strings.Identifier
import unify.tokens.strings.KeywordStatic

class FuncExceptionParser : ParserStatic(
        KeywordStatic("throws"),
        Identifier
) {
    override val TAG = "FuncExceptionParser"
}
