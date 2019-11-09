package unify.parsers

import language.parsers.AlternativeParser
import language.parsers.ParserStatic
import language.sections.OptionalSection
import unify.tokens.strings.KeywordStatic

class OverridesParser : ParserStatic(
        OptionalSection(
                AlternativeParser(
                        KeywordStatic("override"),
                        KeywordStatic("impl")
                )
        )
)
