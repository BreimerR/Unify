package unify.parsers

import language.parsers.Parser
import lib.matcher.sections.AlternativeSection
import lib.matcher.sections.RepetitiveBySection
import lib.matcher.sections.Section
import unify.parsers.operators.BreakDownOperator
import unify.tokens.characters.Coma
import unify.tokens.characters.LSBracket
import unify.tokens.characters.RSBracket
import unify.tokens.strings.Identifier

class ArrayDestructedArgumentParser : Parser() {


    val dItem = Section(
            BreakDownOperator(),
            Identifier
    )

    val midDestruct = Section(
            VariableDeclarationParser(),
            Coma,
            dItem,
            Coma,
            Identifier
    )

    val start = Section(
            Identifier,
            Coma,
            RepetitiveBySection(
                    dItem,
                    Coma
            )
    )

    override val sections = arrayOf(
            Section(RSBracket, name = "START"),
            RepetitiveBySection(
                    AlternativeSection(

                    ),
                    Coma
            ),
            Section(LSBracket, name = "END")
    )
}