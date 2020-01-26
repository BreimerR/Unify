package unify.parsers.expressions

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import lib.matcher.TestableStatic
import unify.parsers.ClassInitParser
import unify.parsers.TypeDeclarationParser
import unify.parsers.controlstractures.IfParser
import unify.parsers.literals.LiteralParser
import unify.parsers.operators.InfixOperatorParser

class InfixExpressionParser : ParserStatic() {

    override var sections: Array<out TestableStatic<String>>
        get() {
            return arrayOf(
                    AlternativeSection(
                            GroupExpressionParser(),
                            FunctionCallParser(),
                            IfParser(),
                            ClassInitParser(),
                            PreFixExpressionParser(),
                            LiteralParser()
                    ),
                    InfixOperatorParser(),
                    AlternativeSection(
                            TypeDeclarationParser(),
                            ExpressionParser()
                    )
            )
        }
        set(value) {}
}