package unify.parsers

import language.parsers.ParserStatic
import unify.tokens.characters.LSBracket
import unify.tokens.characters.RSBracket

class ArrayBodyDeclarationParser : ParserStatic(
        LSBracket,
        RSBracket,
        considerSeparation = false
) {

}
