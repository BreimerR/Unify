package unify.parsers

import language.parsers.ParserStatic
import language.sections.OptionalSection
import language.sections.RepetitiveBySection
import language.sections.Section
import unify.tokens.characters.Coma
import unify.tokens.characters.LBracket
import unify.tokens.characters.RBracket
import unify.tokens.strings.Identifier

class ArgumentsParser : ParserStatic(
        Section(LBracket),
        OptionalSection(
                RepetitiveBySection(
                        ArgumentParser(),
                        Coma,
                        minCount = 0,
                        considerSeparation = false
                ),
                considerSeparation = false
        ),
        Section(RBracket)
) {
}