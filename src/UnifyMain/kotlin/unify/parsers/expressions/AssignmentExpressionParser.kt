package unify.parsers.expressions

import language.parsers.ParserStatic
import unify.parsers.literals.ReferenceParser
import unify.parsers.operators.AssignmentOperatorParser

open class AssignmentExpressionParser : ParserStatic(
        ReferenceParser(),
        AssignmentOperatorParser(),
        ExpressionParser()
)