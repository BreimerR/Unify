package unify.parsers.expressions

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import lib.matcher.TestableStatic
import unify.parsers.ClassInitParser
import unify.parsers.TypeDeclarationParser
import unify.parsers.controlstractures.IfParser
import unify.parsers.functions.CallParser
import unify.parsers.literals.LiteralParser
import unify.parsers.operators.InfixOperatorParser

// expressions can not be in a separate line soo check for new lines
class InfixExpressionParser : ParserStatic() {

    override val TAG = "InfixExpressionParser"

    override var sections: Array<out TestableStatic<String>>
        get() {
            return arrayOf(
                    AlternativeSection(
                            CallParser(),
                            IfParser(),
                            ClassInitParser(),
                            // PreFixExpressionParser(),
                            LiteralParser(),
                            GroupExpressionParser()
                    ),
                    InfixOperatorParser(),
                    ExpressionParser()
            )
        }
        set(value) {}
}