package unify.parsers.headers

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.ZeroOrMany
import unify.tokens.characters.Dot
import unify.tokens.strings.Identifier
import unify.tokens.strings.Keyword
import unify.tokens.strings.KeywordStatic

class PackageDefParser : ParserStatic(
        KeywordStatic("package"),
        ZeroOrMany(
                AlternativeSection(
                        Identifier,
                        Keyword
                ),
                Dot
        ),
        Identifier
)