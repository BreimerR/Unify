package unify.parsers

import language.parsers.ParserStatic
import unify.tokens.characters.Colon

class ReferenceOperatorParser : ParserStatic(
        Colon, Colon,considerSeparation = true
) {
    override val TAG = "ReferenceOperatorParser"
}