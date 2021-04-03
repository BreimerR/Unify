package unify.parsers.controlstractures

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.Section
import language.sections.ZeroOrMany
import lib.matcher.TestableStatic
import unify.parsers.comments.CommentsParser
import unify.parsers.expressions.FunctionCallParser
import unify.parsers.expressions.TAssignmentExpressionParser
import unify.parsers.functions.ActFuncBodyParser
import unify.parsers.functions.CallParser
import unify.parsers.functions.FunctionParser
import unify.parsers.functions.ReturnFuncBodyParser
import unify.parsers.variables.TVariableDeclarationParser
import unify.tokens.characters.LBrace
import unify.tokens.characters.RBrace

class ForBodyParser : ParserStatic() {

    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
                AlternativeSection(
                        Section(
                                LBrace,
                                ZeroOrMany(
                                        AlternativeSection(
                                                CommentsParser(),
                                                IfParser(),
                                                WhileParser(),
                                                WhenParser(),
                                                ForParser(),
                                                DoWhileParser(),
                                                DoThenParser(),
                                                TVariableDeclarationParser(),
                                                TAssignmentExpressionParser(),
                                                CallParser(),
                                                FunctionParser()
                                        )
                                ),
                                RBrace
                        ),
                        ReturnFuncBodyParser(),
                        ActFuncBodyParser()
                )
        )
        set(value) {}
}