package unify.parsers.functions

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.ZeroOrMany
import unify.parsers.comments.CommentsParser
import unify.parsers.controlstractures.ForParser
import unify.parsers.controlstractures.IfParser
import unify.parsers.controlstractures.WhenParser
import unify.parsers.controlstractures.WhileParser
import unify.parsers.expressions.FunctionCallParser
import unify.parsers.expressions.TAssignmentExpressionParser
import unify.parsers.variables.TVariableDeclarationParser
import unify.tokens.characters.LBrace
import unify.tokens.characters.RBrace

open class FunctionItemsParser : ParserStatic(
        LBrace,
        ZeroOrMany(
                AlternativeSection(
                        CommentsParser(),
                        IfParser(),
                        WhileParser(),
                        WhenParser(),
                        ForParser(),
                        TVariableDeclarationParser(),
                        TAssignmentExpressionParser(),
                        FunctionCallParser(),
                        FunctionParser()
                )
        ),
        RBrace
) {
    override val TAG = "FunctionItemsParser"
}