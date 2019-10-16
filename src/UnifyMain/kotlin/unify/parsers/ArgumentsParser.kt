package unify.parsers

import language.parsers.Parser
import language.sections.RepetitiveBySection
import language.sections.Section
import unify.tokens.characters.Coma
import unify.tokens.characters.LBracket
import unify.tokens.characters.RBracket

class ArgumentsParser : Parser(
        Section(LBracket, name = "START"),
        RepetitiveBySection(
                ArgumentParser(),
                Coma,
                name ="ARGS"
        ),
        Section(RBracket, name = "END")
) {
    override val considerSpaces = false
}