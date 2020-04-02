package unify.parsers.expressions

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import lib.matcher.TestableStatic


/**TODO
 * only grouped expressions are allowed to be in multi lines
 * thus this will require all the expression parsers to consider new lines unless as long as they are not used within a
 * grouped expression
 * */
class ExpressionParser : ParserStatic(considerNewLines = true) {
    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
                AlternativeSection(
                        SExpressionParser(),
                        ElvisExpressionParser()
                )
        )
        set(value) {}

    override val TAG = "ExpressionParser"
}