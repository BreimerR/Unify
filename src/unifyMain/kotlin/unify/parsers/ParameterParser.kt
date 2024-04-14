package unify.parsers

import language.parsers.ParserStatic
import language.sections.AlternativeSection

class ParameterParser : ParserStatic(
    AlternativeSection(
        SingleParameterParser()
    )
)
