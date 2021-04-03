package unify.parsers.variables

import language.parsers.ParserStatic
import unify.tokens.characters.LSBracket
import unify.tokens.characters.RSBracket

class ArrayDestructuringParser : ParserStatic(
    LSBracket,
    DestructuringCenterParser(),
    RSBracket,
    name = "ARRAY_DESTRUCTING"
) {

    override val TAG = "ArrayDestructuringParser"

}