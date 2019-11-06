package unify.parsers

import language.parsers.ParserStatic
import language.sections.OptionalSection

class SingleArgumentParser : ParserStatic(
        OptionalSection(
                MutableStateParser()
        ),
        SimpleVariableParser()
)