package unify.parsers

import language.parsers.AlternativeParser
import language.parsers.ParserStatic
import unify.tokens.strings.KeywordStatic

class OverridesParser : ParserStatic(
        AlternativeParser(
                KeywordStatic("override"),
                KeywordStatic("impl")
        )
)