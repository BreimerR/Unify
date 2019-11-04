package unify.parsers.functions

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.OptionalSection
import language.sections.Section
import language.sections.ZeroOrMany
import unify.parsers.VariableDeclarationParser
import unify.parsers.expressions.ExpressionParser
import unify.tokens.characters.LBrace
import unify.tokens.characters.RBrace

class FunctionBodyParser : ParserStatic() {
    override val sections by lazy {

        val endContent = AlternativeSection(
                VariableDeclarationParser(),
                FunctionParser()
        )

        val end = Section(
                LBrace,
                ZeroOrMany(
                        endContent
                ),
                RBrace
        )

        arrayOf(
                AlternativeSection(
                        Section(
                                ActionOperatorParser(),
                                ExpressionParser(),
                                AlternativeSection(
                                        ExpressionParser(),
                                        end
                                )
                        ),
                        Section(
                                ReturnActionOperatorParser(),
                                AlternativeSection(
                                        ExpressionParser(),
                                        end
                                )
                        ),
                        end

                )
        )
    }
}
