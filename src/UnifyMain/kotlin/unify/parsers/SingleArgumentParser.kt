package unify.parsers

import language.parsers.ParserStatic
import language.sections.OptionalSection
import unify.parsers.variables.SimpleVariableParser
import unify.parsers.variables.VariableDeclarationParser

class SingleArgumentParser : ParserStatic(
        OptionalSection(
                MutableStateParser()
        ),
        SimpleVariableParser()
)