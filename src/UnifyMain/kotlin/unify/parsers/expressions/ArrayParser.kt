package unify.parsers.expressions

import language.parsers.ParserStatic
import language.sections.OptionalSection
import language.sections.RepetitiveBySection
import unify.tokens.characters.LSBracket
import unify.tokens.characters.RSBracket

class ArrayParser : ParserStatic(
        LSBracket,
        OptionalSection(
                RepetitiveBySection(
                        ExpressionParser()
                )
        ),
        RSBracket
) {

}
