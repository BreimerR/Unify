package unify.parsers

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import unify.tokens.strings.KeywordStatic

class MutableStateParser : ParserStatic(
        AlternativeSection(
                KeywordStatic("var"),
                KeywordStatic("val")
        )
) {
}