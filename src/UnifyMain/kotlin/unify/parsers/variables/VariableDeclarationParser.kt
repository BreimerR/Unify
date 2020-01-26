package unify.parsers.variables

import language.parsers.ParserStatic
import unify.parsers.MutableStateParser

class VariableDeclarationParser : ParserStatic(
        MutableStateParser(),
        SimpleVariableParser()
)