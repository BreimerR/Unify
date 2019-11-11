package unify.parsers.expressions

import language.parsers.AlternativeParser
import language.parsers.ParserStatic
import language.sections.AlternativeSection
import lib.matcher.TestableStatic

class ExpressionParser : AlternativeParser() {
    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
                SExpressionParser(),
                ElvisExpressionParser()
        )
        set(value) {}
}