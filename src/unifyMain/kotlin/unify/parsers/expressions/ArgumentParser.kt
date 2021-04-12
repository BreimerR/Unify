package unify.parsers.expressions

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import unify.parsers.literals.NumberParser
import unify.parsers.literals.ReferenceParser

class ArgumentParser : ParserStatic(
    AlternativeSection(
        ExpressionParser(),
        ReferenceParser(),
        NumberParser()
    )
)