package unify.parsers

import language.parsers.ParserStatic

class SingleArgumentParser : ParserStatic(
        VariableDeclarationParser()
)