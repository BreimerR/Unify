package unify.parsers

import language.parsers.Parser
import lib.matcher.sections.AlternativeSection
import unify.tokens.strings.KeywordStatic

class MutabilityStateParser : Parser(
        AlternativeSection(
                KeywordStatic("var"),
                KeywordStatic("val")
        ),
        name = "MUTABILITY_STATE"
) {

}