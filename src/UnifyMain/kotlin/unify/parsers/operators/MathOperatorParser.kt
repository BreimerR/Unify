package unify.parsers.operators

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.Section
import unify.tokens.characters.*

class MathOperatorParser : ParserStatic(
        AlternativeSection(
                Section(Plus),
                Section(Minus),
                Section(Percent),
                Section(Asterisk),
                Section(FSlash),
                Section(Ampersand)
        )
) {

    override val TAG = "MathOperatorParser"

    var age = 12

}
