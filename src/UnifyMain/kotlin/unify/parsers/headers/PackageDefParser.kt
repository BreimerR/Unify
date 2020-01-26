package unify.parsers.headers

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.RepetitiveBySection
import unify.tokens.characters.Dot
import unify.tokens.strings.Identifier
import unify.tokens.strings.IdentifierStatic
import unify.tokens.strings.Keyword
import unify.tokens.strings.KeywordStatic

class PackageDefParser : ParserStatic(
        IdentifierStatic("package"),
        RepetitiveBySection(
                AlternativeSection(
                        Identifier,
                        Keyword
                ),
                Dot
        )
)