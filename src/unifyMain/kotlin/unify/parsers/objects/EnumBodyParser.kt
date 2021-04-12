package unify.parsers.objects

import language.parsers.ParserStatic
import language.sections.OptionalSection
import language.sections.RepetitiveBySection
import unify.tokens.characters.Coma
import unify.tokens.characters.LBrace
import unify.tokens.characters.RBrace
import unify.tokens.strings.Identifier


class EnumBodyParser : ParserStatic(
    LBrace,
    OptionalSection(
        RepetitiveBySection(
            Coma,
            Identifier
        )
    ),
    RBrace
)
