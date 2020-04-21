package unify.parsers

import language.parsers.ParserStatic
import language.sections.OptionalSection
import language.sections.RepetitiveBySection
import unify.tokens.characters.Coma
import unify.tokens.characters.LBracket
import unify.tokens.characters.RBracket

class ArgumentsParser : ParserStatic(
        LBracket,
        OptionalSection(
                RepetitiveBySection(
                        ArgumentParser(),
                        Coma
                )
        ),
        RBracket
)