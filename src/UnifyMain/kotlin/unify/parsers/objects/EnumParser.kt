package unify.parsers.objects

import language.parsers.ParserStatic
import unify.tokens.strings.Identifier
import unify.tokens.strings.KeywordStatic

class EnumParser : ParserStatic(
        KeywordStatic("enum"),
        Identifier,
        EnumBodyParser()
)