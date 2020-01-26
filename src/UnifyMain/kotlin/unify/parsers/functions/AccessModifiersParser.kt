package unify.parsers.functions

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.OptionalSection
import unify.tokens.strings.KeywordStatic

class AccessModifiersParser : ParserStatic(
        OptionalSection(
                AlternativeSection(
                        KeywordStatic("private"),
                        KeywordStatic("protected"),
                        KeywordStatic("public")
                )
        ),
        OptionalSection(
                KeywordStatic("static")
        ),
        OptionalSection(
                KeywordStatic("final")
        )
)
