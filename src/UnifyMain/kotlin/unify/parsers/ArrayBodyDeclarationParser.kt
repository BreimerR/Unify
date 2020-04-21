package unify.parsers

import language.parsers.ParserStatic
import language.sections.OptionalSection
import unify.parsers.numbers.IntegerParser
import unify.tokens.characters.LSBracket
import unify.tokens.characters.RSBracket

class ArrayBodyDeclarationParser : ParserStatic(
        LSBracket,
        OptionalSection(
                IntegerParser()
        ),
        RSBracket
)