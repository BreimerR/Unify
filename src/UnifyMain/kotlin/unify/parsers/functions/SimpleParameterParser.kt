package unify.parsers.functions

import language.parsers.ParserStatic
import language.sections.OptionalSection
import language.sections.RepetitiveBySection
import language.sections.ZeroOrMany
import unify.parsers.expressions.ExpressionParser
import unify.tokens.characters.Coma

class SimpleParameterParser : ParserStatic(
        RepetitiveBySection(
                ExpressionParser(),
                Coma

        )
)