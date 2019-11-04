package unify.parsers.expressions

import language.parsers.ParserStatic
import language.sections.*
import unify.parsers.VariableDeclarationParser
import unify.parsers.literals.LiteralParser
import unify.parsers.operators.InfixOperatorParser
import unify.tokens.characters.Exclamation

class ExpressionParser : ParserStatic() {
    override val sections by lazy {
        arrayOf(
                OptionalSection(
                        Exclamation
                ),
                AlternativeSection(
                        GroupExpressionParser(),
                        Section(
                                AlternativeSection(
                                        LiteralParser(),
                                        FunctionCallParser()
                                ),
                                OptionalSection(
                                        PassiveSection(
                                                NotSection(
                                                        VariableDeclarationParser()
                                                )
                                        ),
                                        InfixOperatorParser(),
                                        ExpressionParser()
                                )
                        )
                )
        )
    }

    fun update(): Boolean = false;


}