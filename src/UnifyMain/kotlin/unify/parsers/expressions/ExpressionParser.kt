package unify.parsers.expressions

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.OptionalSection
import language.sections.Section
import lib.matcher.items.ItemsStatic
import unify.parsers.controlstractures.IfParser
import unify.parsers.literals.LiteralParser
import unify.parsers.operators.InfixOperatorParser
import unify.tokens.characters.Colon
import unify.tokens.characters.Exclamation
import unify.tokens.characters.Question
import unify.tokens.characters.SColon

class ExpressionParser : ParserStatic() {
    override val sections by lazy {
        arrayOf(
                OptionalSection(
                        Exclamation
                ),
                UnTerminatedExpressionParser(),
                OptionalSection(
                        SColon
                )
        )
    }
}