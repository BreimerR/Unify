package unify.parsers.controlstractures

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.Section
import language.sections.ZeroOrMany
import lib.matcher.TestableStatic
import unify.parsers.TArithmeticAdjustmentParser
import unify.parsers.comments.CommentsParser
import unify.parsers.expressions.FunctionCallParser
import unify.parsers.expressions.TAssignmentExpressionParser
import unify.parsers.functions.*
import unify.parsers.variables.TVariableDeclarationParser
import unify.tokens.characters.LBrace
import unify.tokens.characters.RBrace

class ForBodyParser : ParserStatic() {

    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
                AlternativeSection(
                        FunctionItemsParser(),
                        ReturnFuncBodyParser(),
                        ActFuncBodyParser()
                )
        )
        set(value) {}
}