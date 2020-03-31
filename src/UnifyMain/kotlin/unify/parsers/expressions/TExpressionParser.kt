package unify.parsers.expressions

import language.parsers.ParserStatic
import language.sections.OptionalSection
import lib.matcher.TestableStatic
import unify.tokens.characters.Exclamation
import unify.tokens.characters.SColon

class TExpressionParser : ParserStatic() {
    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
                OptionalSection(
                        Exclamation
                ),
                ExpressionParser(),
                OptionalSection(
                        SColon
                )
        )
        set(value) {}
}