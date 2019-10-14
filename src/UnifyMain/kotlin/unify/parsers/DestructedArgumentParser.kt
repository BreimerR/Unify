package unify.parsers

import language.parsers.Parser
import lib.matcher.sections.Section
import lib.matcher.sections.AlternativeSection
import unify.parsers.operators.BreakDownOperator


class DestructedArgumentParser : Parser(
        AlternativeSection(
                Section(
                        BreakDownOperator(),
                        BareVariableDeclarationParser()
                )
        )
) {

    override val considerSpaces = false
}