package unify.parsers.functions

import language.parsers.ParserStatic
import language.sections.AlternativeSection

class ParametersParser : ParserStatic(
        AlternativeSection(
                SimpleParameterParser()
        )
)