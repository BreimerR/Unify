package unify.parsers.expressions

import language.parsers.Parser
import language.sections.AlternativeSection
import language.sections.OptionalSection
import language.sections.RepetitiveBySection
import language.sections.Section
import lib.matcher.TestableStatic
import unify.parsers.NumberParser
import unify.parsers.ReferenceParser
import unify.tokens.characters.Dot
import unify.tokens.strings.Identifier

class ExpressionParser : Parser(
        RepetitiveBySection(
                Identifier, Dot,
                considerSpaces = true
        ),
        name = "EXPRESSION"
) {


}