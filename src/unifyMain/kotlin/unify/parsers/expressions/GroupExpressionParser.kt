package unify.parsers.expressions

import language.parsers.ParserStatic
import unify.tokens.characters.LBracket
import unify.tokens.characters.RBracket

class GroupExpressionParser : ParserStatic(
        LBracket,
        ExpressionParser(),
        RBracket,
        name = "GROUP_EXPRESSION"
) {
    override val TAG = "GroupExpressionParser"
}