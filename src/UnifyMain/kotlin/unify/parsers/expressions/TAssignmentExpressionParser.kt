package unify.parsers.expressions

import lib.matcher.TestableStatic
import unify.parsers.TerminatorParserPartial

class TAssignmentExpressionParser : AssignmentExpressionParser() {
    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
                *super.sections,
                TerminatorParserPartial()
        )
        set(value) {}
}