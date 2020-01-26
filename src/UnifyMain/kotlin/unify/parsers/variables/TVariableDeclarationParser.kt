package unify.parsers.variables

import language.parsers.ParserStatic
import unify.parsers.TerminatorParser

class TVariableDeclarationParser : ParserStatic(
        VariableDeclarationParser(),
        TerminatorParser()
)