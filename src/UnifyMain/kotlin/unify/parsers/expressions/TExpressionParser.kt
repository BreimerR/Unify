package unify.parsers.expressions

import language.parsers.ParserStatic
import language.sections.OptionalSection
import lib.matcher.TestableStatic
import unify.parsers.TerminatorParser
import unify.tokens.characters.Exclamation

class TExpressionParser : ParserStatic() {
    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
                OptionalSection(
                        Exclamation
                ),
                ExpressionParser(),
                TerminatorParser()
        )
        set(value) {}
}