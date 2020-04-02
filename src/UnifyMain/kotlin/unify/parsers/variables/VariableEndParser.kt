package unify.parsers.variables

import language.parsers.ParserStatic
import lib.matcher.TestableStatic
import unify.parsers.expressions.ExpressionParser
import unify.tokens.characters.Equals


/**@structure
 * : typeDeclaration :: defaultValue
 * */
class VariableEndParser : ParserStatic() {
    override val TAG = "VariableEndParser"

    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
                Equals,
                ExpressionParser()
        )
        set(value) {}
}