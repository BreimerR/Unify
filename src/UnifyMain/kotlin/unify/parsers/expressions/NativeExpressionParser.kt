package unify.parsers.expressions

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.OptionalSection
import language.sections.Section
import unify.parsers.ClassInitParser
import unify.parsers.controlstractures.IfParser
import unify.parsers.literals.LiteralParser
import unify.parsers.operators.InfixOperatorParser

class NativeExpressionParser : ParserStatic(
        Section(
                AlternativeSection(
                        IfParser(),
                        ClassInitParser(),
                        FunctionCallParser(),
                        LiteralParser()

                ),
                OptionalSection(
                        InfixOperatorParser(),
                        ExpressionParser()
                )
        )
)