package unify.parsers.functions

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.Section
import language.sections.ZeroOrMany
import lib.matcher.TestableStatic
import unify.parsers.controlstractures.WhenParser
import unify.parsers.controlstractures.WhileParser
import unify.parsers.expressions.AssignmentExpressionParser
import unify.parsers.expressions.ExpressionParser
import unify.parsers.variables.VariableDeclarationParser
import unify.tokens.characters.LBrace
import unify.tokens.characters.RBrace

class ReturnFuncBodyParser : ParserStatic() {

    override val TAG= "ReturnFuncBodyParser"

    override var sections: Array<out TestableStatic<String>>
        get() {
            return arrayOf(
                    ReturnActionOperatorParser(),
                    AlternativeSection(
                            // Terminating this causes if expression0 else expression1 to fail as expression 0 requires termination
                            // NOT sure how other operations deal with this though expressions are limited to single lines
                            ExpressionParser(),
                            Section(
                                    LBrace,
                                    ZeroOrMany(
                                            AlternativeSection(
                                                    WhileParser(),
                                                    WhenParser(),
                                                    VariableDeclarationParser(),
                                                    AssignmentExpressionParser(),
                                                    ExpressionParser(),
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