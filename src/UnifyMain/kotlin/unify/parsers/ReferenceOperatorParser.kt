package unify.parsers

import language.parsers.ParserStatic
import unify.tokens.characters.Colon

class ReferenceOperatorParser : ParserStatic(
        Colon, Colon
) {
    override val TAG = "ReferenceOperatorParser"
}