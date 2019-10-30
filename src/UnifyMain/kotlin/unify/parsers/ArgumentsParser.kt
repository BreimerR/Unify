package unify.parsers

import language.parsers.ParserStatic
import language.sections.RepetitiveBySection
import language.sections.Section
import unify.tokens.characters.Coma
import unify.tokens.characters.LBracket
import unify.tokens.characters.RBracket

class ArgumentsParser : ParserStatic(
        Section(LBracket),
        RepetitiveBySection(
                ArgumentParser(),
                Coma,
                minCount = 0
        ),
        Section(RBracket)
) {
}