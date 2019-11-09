package unify.parsers.functions

import language.parsers.ParserStatic
import language.sections.OptionalSection
import unify.tokens.strings.Identifier
import unify.tokens.strings.KeywordStatic

class FuncExceptionParser : ParserStatic(
        OptionalSection(
                KeywordStatic("throws"),
                Identifier
        )
)
