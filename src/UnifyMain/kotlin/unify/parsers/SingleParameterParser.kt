package unify.parsers

import language.parsers.ParserStatic
import language.sections.OptionalSection
import unify.parsers.variables.SimpleVariableParser

class SingleParameterParser : ParserStatic(
        OptionalSection(
                MutableStateParser()
        ),
        SimpleVariableParser()
)