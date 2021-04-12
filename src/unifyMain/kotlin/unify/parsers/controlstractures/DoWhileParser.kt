package unify.parsers.controlstractures

import language.parsers.ParserStatic
import lib.matcher.TestableStatic
import unify.parsers.TerminatorParser
import unify.parsers.expressions.ExpressionParser
import unify.parsers.expressions.TExpressionParser
import unify.parsers.functions.FunctionBodyParser
import unify.tokens.strings.KeywordStatic

class DoWhileParser : ParserStatic() {
    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
                KeywordStatic("do"),
                FunctionBodyParser(),
                KeywordStatic("while"),
                TExpressionParser()
        )
        set(value) {}
}