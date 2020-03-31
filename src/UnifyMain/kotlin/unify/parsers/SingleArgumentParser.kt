package unify.parsers

import language.parsers.ParserStatic
import language.sections.OptionalSection
import unify.parsers.variables.SimpleVariableParser

class SingleArgumentParser : ParserStatic(
        OptionalSection(
                MutableStateParser()
        ),
        SimpleVariableParser()
){
        override val TAG = "SingleArgumentParser"
}