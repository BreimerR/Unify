package unify.parsers.functions

import language.parsers.ParserStatic
import unify.tokens.characters.Equals
import unify.tokens.characters.GThan

class ReturnActionOperatorParser : ParserStatic(
        Equals,
        GThan
)