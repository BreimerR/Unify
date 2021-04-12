package unify.parsers.expressions

import language.parsers.AlternativeParser
import unify.parsers.controlstractures.IfParser
import unify.parsers.functions.CallParser
import unify.parsers.literals.LiteralParser

class ExpressionStartParser : AlternativeParser(
        IfParser(),
        LiteralParser(),
        CallParser()
)