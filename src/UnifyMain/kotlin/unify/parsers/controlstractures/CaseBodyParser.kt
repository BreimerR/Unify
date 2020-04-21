package unify.parsers.controlstractures

import language.parsers.ParserStatic
import language.sections.ZeroOrMany
import unify.parsers.expressions.ExpressionParser
import unify.parsers.functions.FunctionBodyParser
import unify.tokens.characters.LBrace
import unify.tokens.characters.RBrace

class CaseBodyParser : ParserStatic(
        LBrace,
        ZeroOrMany(
                ExpressionParser(),
                FunctionBodyParser()
        ),
        RBrace,
        name="S_CASE_BODY"
)
