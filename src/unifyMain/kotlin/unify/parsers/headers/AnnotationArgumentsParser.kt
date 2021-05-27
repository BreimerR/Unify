package unify.parsers.headers

import language.parsers.ParserStatic
import unify.tokens.characters.LBracket
import unify.tokens.characters.RBracket

class AnnotationArgumentsParser : ParserStatic(
    LBracket,
    RBracket
)