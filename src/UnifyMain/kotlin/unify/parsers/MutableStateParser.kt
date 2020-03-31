package unify.parsers

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import unify.tokens.strings.KeywordStatic

// var read write
// val read only
// const runtime value
class MutableStateParser : ParserStatic(
        AlternativeSection(
                KeywordStatic("var"),
                KeywordStatic("val")
        )
) {
    override val TAG = "MutableStateParser"
}