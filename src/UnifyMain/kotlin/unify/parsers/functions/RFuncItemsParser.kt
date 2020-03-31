package unify.parsers.functions

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.ZeroOrMany
import unify.parsers.comments.CommentsParser
import unify.parsers.variables.TVariableDeclarationParser
import unify.parsers.controlstractures.WhenParser
import unify.parsers.controlstractures.WhileParser
import unify.parsers.expressions.TExpressionParser
import unify.parsers.expressions.TAssignmentExpressionParser
import unify.tokens.characters.LBrace
import unify.tokens.characters.RBrace

class RFuncItemsParser : ParserStatic(
        LBrace,
        ZeroOrMany(
                AlternativeSection(
                        CommentsParser(),
                        WhileParser(),
                        WhenParser(),
                        TVariableDeclarationParser(),
                        TAssignmentExpressionParser(),
                        TExpressionParser(),
                        FunctionParser()
                )
        ),
        RBrace
)