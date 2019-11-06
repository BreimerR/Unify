package unify.parsers.expressions

import unify.tokens.characters.SColon
import language.sections.OptionalSection

class TAssignmentExpressionParser : AssignmentExpressionParser() {
    override val sections by lazy {
        arrayOf (
                *super.sections, OptionalSection(SColon)
        )
    }
}