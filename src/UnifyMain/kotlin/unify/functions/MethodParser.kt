package unify.functions

import language.parsers.ParserStatic

class MethodParser : ParserStatic(
        AccessControlModifiersParser(),
        FunctionContentParser()
)