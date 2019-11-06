package unify.parsers

import language.parsers.ParserStatic
import unify.parsers.operators.MathOperatorParser
import unify.tokens.characters.Equals

class AugAssignmentOperatorParser : ParserStatic(
        MathOperatorParser(),
        Equals
)