package unify.parsers.headers

import language.parsers.ParserStatic
import language.sections.OptionalSection
import language.sections.RepetitiveSection
import unify.tokens.characters.Asterisk
import unify.tokens.characters.Dot
import unify.tokens.strings.Identifier
import unify.tokens.strings.KeywordStatic

class ImportParser : ParserStatic(
    KeywordStatic("import"),
    Identifier,
    RepetitiveSection(
        Dot,
        Identifier,
        minCount = 0
    ),
    OptionalSection(
        Dot,
        Asterisk,
    ),
    OptionalSection(
        KeywordStatic("as"),
        Identifier
    )
)