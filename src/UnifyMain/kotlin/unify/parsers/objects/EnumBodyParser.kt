package unify.parsers.objects

import language.parsers.ParserStatic
import language.sections.OptionalSection
import language.sections.RepetitiveBySectionReMaster
import unify.tokens.characters.Coma
import unify.tokens.characters.LBrace
import unify.tokens.characters.RBrace
import unify.tokens.strings.Identifier


class EnumBodyParser : ParserStatic(
    LBrace,
    OptionalSection(
        RepetitiveBySectionReMaster(
            Coma,
            Identifier
        )
    ),
    RBrace
)
