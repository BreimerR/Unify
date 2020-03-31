package unify.parsers.expressions

import lib.matcher.TestableStatic
import unify.parsers.TerminatorParser

class TAssignmentExpressionParser : AssignmentExpressionParser() {

    override val TAG = "TAssignmentExpressionParser"

    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
                *super.sections,
                TerminatorParser()
        )
        set(value) {}
}