package unify.parsers.functions

import language.parsers.AlternativeParser
import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.Section
import language.sections.ZeroOrMany
import lib.matcher.TestableStatic
import unify.parsers.TerminatedVariableDeclarationParser
import unify.parsers.controlstractures.WhenParser
import unify.parsers.controlstractures.WhileParser
import unify.parsers.expressions.ExpressionParser
import unify.parsers.expressions.TAssignmentExpressionParser
import unify.tokens.characters.LBrace
import unify.tokens.characters.RBrace

class ReturnFuncBodyParser : ParserStatic() {
    override val sections by lazy {
        arrayOf(
                ReturnActionOperatorParser(),
                AlternativeSection(
                        ExpressionParser(),
                        Section(
                                LBrace,
                                ZeroOrMany(
                                        AlternativeSection(
                                                WhileParser(),
                                                WhenParser(),
                                                TerminatedVariableDeclarationParser(),
                                                TAssignmentExpressionParser(),
                                                ExpressionParser(),
                                                FunctionParser()
                                        )
                                ),
                                RBrace
                        )
                )
        )
    }
}

class FunctionBodyParser : AlternativeParser() {
    override val sections by lazy {

        arrayOf(
                FunctionItemsParser(),
                ReturnFuncBodyParser(),
                ActFuncBodyParser()
        )
    }
}
