package unify.parsers.functions

import language.parsers.ParserStatic

class MethodParser : ParserStatic(
        AccessModifiersParser(),
        FunctionContentParser()
) {
    override val TAG = "MethodParser"
}