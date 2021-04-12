package unify.parsers.functions

import language.parsers.ParserStatic
import language.sections.*
import lib.matcher.TestableStatic
import unify.parsers.expressions.ExpressionParser
import unify.parsers.literals.ReferenceParser
import unify.tokens.characters.Coma
import unify.tokens.characters.LBracket
import unify.tokens.characters.RBracket

class CallParser : ParserStatic(considerNewLines = false) {
    // Ends with works better for such a situation.
    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
            ReferenceParser(),
            LBracket,
            OptionalSection(
                RepetitiveBySection(
                    Coma,
                    ExpressionParser()
                )
            ),
            RBracket
        )
        set(value) {}

}