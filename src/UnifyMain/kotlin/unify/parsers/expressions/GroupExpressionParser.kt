package unify.parsers.expressions

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.Section
import unify.tokens.characters.LBracket
import unify.tokens.characters.RBracket

class GroupExpressionParser : ParserStatic(
        LBracket,
        ExpressionParser(),
        RBracket
)