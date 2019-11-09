package unify.parsers.expressions

import unify.tokens.characters.SColon
import language.sections.OptionalSection
import lib.matcher.TestableStatic

class TAssignmentExpressionParser : AssignmentExpressionParser() {
    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
                *super.sections, OptionalSection(SColon)
        )
        set(value) {}
}