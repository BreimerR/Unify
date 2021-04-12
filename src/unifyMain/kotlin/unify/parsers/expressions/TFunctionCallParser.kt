package unify.parsers.expressions

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import lib.matcher.TestableStatic
import unify.parsers.TerminatorParser
import unify.parsers.functions.CallParser


class TFunctionCallParser : ParserStatic(
    AlternativeSection(
        ParameterFunctionCall(),
        InfixFunctionCallParser()
    ),
    TerminatorParser()
)