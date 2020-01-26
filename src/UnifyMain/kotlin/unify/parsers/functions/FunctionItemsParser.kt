package unify.parsers.functions

import language.sections.ZeroOrMany
import language.parsers.ParserStatic
import unify.tokens.characters.LBrace
import unify.tokens.characters.RBrace
import language.sections.AlternativeSection
import unify.parsers.comments.CommentsParser
import unify.parsers.controlstractures.ForParser
import unify.parsers.controlstractures.WhileParser
import unify.parsers.variables.TVariableDeclarationParser
import unify.parsers.controlstractures.IfParser
import unify.parsers.controlstractures.WhenParser
import unify.parsers.expressions.FunctionCallParser
import unify.parsers.expressions.TAssignmentExpressionParser

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
)