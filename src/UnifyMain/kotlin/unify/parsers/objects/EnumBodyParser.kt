package unify.parsers.objects

import language.parsers.ParserStatic
import language.sections.OptionalSection
import language.sections.RepetitiveBySection
import unify.tokens.characters.Coma
import unify.tokens.characters.LBrace
import unify.tokens.characters.RBracket
import unify.tokens.strings.Identifier


class EnumBodyParser : ParserStatic(
        LBrace,
        OptionalSection(
                RepetitiveBySection(
                        Identifier,
                        Coma,
                        minCount = 0
                )
        ),
        RBracket
)
