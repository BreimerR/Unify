package unify.parsers.expressions

import language.parsers.ParserStatic
import lib.matcher.TestableStatic
import unify.parsers.literals.ReferenceParser
import unify.parsers.operators.AssignmentOperatorParser

open class AssignmentExpressionParser : ParserStatic() {


    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
            ReferenceParser(),
            AssignmentOperatorParser(),
            ExpressionParser()
        )
        set(value) {}

}



