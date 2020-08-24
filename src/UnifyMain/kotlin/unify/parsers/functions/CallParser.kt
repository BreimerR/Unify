package unify.parsers.functions

import language.parsers.ParserStatic
import language.sections.*
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic
import unify.parsers.expressions.ExpressionParser
import unify.parsers.literals.ReferenceParser
import unify.tokens.characters.Coma
import unify.tokens.characters.LBracket
import unify.tokens.characters.RBracket
import unify.tokens.strings.Identifier

class CallParser : ParserStatic(considerNewLines = true) {
    // Ends with works better for such a situation.
    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
                ReferenceParser(),
                LBracket,
                OptionalSection(
                        RepetitiveBySection(
                                ExpressionParser(),
                                Coma,
                                minCount = 1
                        )
                ),
                RBracket
        )
        set(value) {}

}