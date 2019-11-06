package unify.parsers.functions

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.ZeroOrMany
import unify.parsers.TerminatedVariableDeclarationParser
import unify.parsers.controlstractures.WhenParser
import unify.parsers.controlstractures.WhileParser
import unify.parsers.expressions.ExpressionParser
import unify.parsers.expressions.TAssignmentExpressionParser
import unify.tokens.characters.LBrace
import unify.tokens.characters.RBrace

class RFuncItemsParser : ParserStatic(
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