package unify.parsers.controlstractures

import language.parsers.ParserStatic
import unify.parsers.expressions.ExpressionParser
import unify.parsers.functions.FunctionBodyParser
import unify.tokens.strings.KeywordStatic

class WhileParser : ParserStatic(
        KeywordStatic("while"),
        ExpressionParser(),
        FunctionBodyParser()
){
    override  val TAG = "WhileParser"
}