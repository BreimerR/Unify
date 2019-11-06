package unify.parsers

import language.parsers.ParserStatic

class VariableDeclarationParser : ParserStatic(
        MutableStateParser(),
        SimpleVariableParser()
)