package unify.parsers.functions

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.Section
import language.sections.ZeroOrMany
import lib.matcher.TestableStatic
import unify.parsers.TerminatedVariableDeclarationParser
import unify.parsers.controlstractures.WhenParser
import unify.parsers.controlstractures.WhileParser
import unify.parsers.expressions.TExpressionParser
import unify.parsers.expressions.TAssignmentExpressionParser
import unify.tokens.characters.LBrace
import unify.tokens.characters.RBrace

class ReturnFuncBodyParser : ParserStatic() {
    override var sections: Array<out TestableStatic<String>>
        get() {
            return arrayOf(
                    ReturnActionOperatorParser(),
                    AlternativeSection(
                            TExpressionParser(),
                            Section(
                                    LBrace,
                                    ZeroOrMany(
                                            AlternativeSection(
                                                    WhileParser(),
                                                    WhenParser(),
                                                    TerminatedVariableDeclarationParser(),
                                                    TAssignmentExpressionParser(),
                                                    TExpressionParser(),
                                                    FunctionParser()
                                            )
                                    ),
                                    RBrace
                            )
                    )
            )
        }
        set(value) {}
}