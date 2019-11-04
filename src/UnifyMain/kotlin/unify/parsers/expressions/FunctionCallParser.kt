package unify.parsers.expressions

import language.parsers.ParserStatic
import language.sections.OptionalSection
import language.sections.RepetitiveBySection
import unify.parsers.literals.ReferenceParser
import unify.tokens.characters.LBracket
import unify.tokens.characters.RBracket

class FunctionCallParser : ParserStatic(
        ReferenceParser(),
        LBracket,
        OptionalSection(
                RepetitiveBySection(
                        ExpressionParser()
                )
        ),
        RBracket
)
