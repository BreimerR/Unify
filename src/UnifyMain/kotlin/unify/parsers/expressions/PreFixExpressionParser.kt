package unify.parsers.expressions

import language.parsers.ParserStatic
import language.sections.*
import unify.parsers.literals.LiteralParser
import unify.parsers.literals.ReferenceParser
import unify.tokens.characters.*

class PreFixExpressionParser : ParserStatic(
        ReferenceParser(),
        AlternativeSection(
                LiteralParser(),
                ReferenceParser()
        )
)