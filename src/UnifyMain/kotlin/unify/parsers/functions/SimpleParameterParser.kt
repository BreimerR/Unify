package unify.parsers.functions

import language.parsers.ParserStatic
import language.sections.RepetitiveBySectionReMaster
import unify.parsers.expressions.ExpressionParser
import unify.tokens.characters.Coma

class SimpleParameterParser : ParserStatic(
    RepetitiveBySectionReMaster(
        Coma,
        ExpressionParser()
    )
)