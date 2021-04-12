package unify.parsers.functions

import language.parsers.ParserStatic
import language.sections.RepetitiveBySection
import unify.parsers.expressions.ExpressionParser
import unify.tokens.characters.Coma

class SimpleParameterParser : ParserStatic(
    RepetitiveBySection(
        Coma,
        ExpressionParser()
    )
)