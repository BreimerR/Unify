package unify.parsers

import language.parsers.ParserStatic
import unify.tokens.strings.KeywordStatic

class DelegationParser : ParserStatic(
        KeywordStatic("by"),
        TypeInitializationParser()
)