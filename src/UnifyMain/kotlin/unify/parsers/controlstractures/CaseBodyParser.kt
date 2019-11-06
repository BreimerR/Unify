package unify.parsers.controlstractures

import language.parsers.ParserStatic
import language.sections.ZeroOrMany
import unify.tokens.characters.LBrace
import unify.tokens.characters.RBrace
import language.sections.OptionalSection
import unify.tokens.strings.KeywordStatic
import unify.parsers.functions.RFuncBodyParser
import unify.parsers.expressions.ExpressionParser

class CaseBodyParser : ParserStatic(
        LBrace,
        ZeroOrMany(
                ExpressionParser(),
                RFuncBodyParser()
        ),
        RBrace
)
