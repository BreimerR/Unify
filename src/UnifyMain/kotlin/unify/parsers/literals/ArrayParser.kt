package unify.parsers.literals

import language.parsers.ParserStatic
import language.sections.OptionalSection
import language.sections.RepetitiveBySection
import unify.parsers.expressions.ExpressionParser
import unify.tokens.characters.Coma
import unify.tokens.characters.LSBracket
import unify.tokens.characters.RSBracket

class ArrayParser : ParserStatic(
        LSBracket,
        OptionalSection(
                RepetitiveBySection(
                        ExpressionParser(),
                        Coma
                )
        ),
        RSBracket
) {

}
