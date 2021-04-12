package unify.parsers.functions

import language.parsers.ParserStatic
import unify.parsers.expressions.FunctionStartParser

class FunctionContentParser : ParserStatic(
        FunctionStartParser(),
        // function body
        FunctionBodyParser()
) {
    override val TAG: String = "FunctionContentParser"
}