package unify.parsers.functions

import language.parsers.ParserStatic
import unify.tokens.characters.GThan
import unify.tokens.characters.Minus

class ActionOperatorParser : ParserStatic(
        Minus,
        GThan
)
