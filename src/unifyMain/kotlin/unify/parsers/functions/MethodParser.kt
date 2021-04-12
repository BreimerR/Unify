package unify.parsers.functions

import language.parsers.ParserStatic

class MethodParser : ParserStatic(
        FunctionContentParser()
) {
    override val TAG = "MethodParser"
}