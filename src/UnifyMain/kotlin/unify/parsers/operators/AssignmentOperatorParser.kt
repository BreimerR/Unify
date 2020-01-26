package unify.parsers.operators

import language.parsers.AlternativeParser
import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.Section
import lib.matcher.sections.AlternativeSectionStatic
import unify.parsers.AugAssignmentOperatorParser
import unify.tokens.characters.Equals

class AssignmentOperatorParser : AlternativeParser(
        Section(Equals),
        AugAssignmentOperatorParser()
)
