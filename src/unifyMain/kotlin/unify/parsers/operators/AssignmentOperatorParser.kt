package unify.parsers.operators

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.Section
import unify.parsers.AugAssignmentOperatorParser
import unify.tokens.characters.Equals

class AssignmentOperatorParser : ParserStatic(
        AlternativeSection(
                Section(Equals),
                AugAssignmentOperatorParser()
        )
) {
    override val TAG = "AssignmentOperatorParser"
}