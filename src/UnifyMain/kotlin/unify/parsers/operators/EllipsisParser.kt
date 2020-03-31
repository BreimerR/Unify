package unify.parsers.operators

import language.parsers.ParserStatic
import unify.tokens.characters.Dot

class EllipsisParser : ParserStatic(
        Dot,
        Dot,
        Dot,
        considerSeparation = true
) {
}