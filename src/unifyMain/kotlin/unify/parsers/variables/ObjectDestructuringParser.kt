package unify.parsers.variables

import language.parsers.ParserStatic
import unify.tokens.characters.LBrace
import unify.tokens.characters.RBrace

class ObjectDestructuringParser : ParserStatic(
    LBrace,
    DestructuringCenterParser(),
    RBrace,
    name = "OBJ_DESTRUCTING"
) {
    override val TAG = "ObjectDistractingParser"
}