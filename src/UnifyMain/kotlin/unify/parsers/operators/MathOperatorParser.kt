package unify.parsers.operators

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.Section
import unify.tokens.characters.*

class MathOperatorParser : ParserStatic(
        AlternativeSection(
                Plus,
                Minus,
                Percent,
                Asterisk,
                FSlash,
                Ampersand
        )
) {

    override val TAG = "MathOperatorParser"

    var age = 12

}
