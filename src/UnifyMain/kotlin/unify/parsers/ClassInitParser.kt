package unify.parsers

import language.parsers.ParserStatic
import language.sections.OptionalSection
import unify.parsers.expressions.FunctionCallParser
import unify.tokens.characters.SColon
import unify.tokens.strings.KeywordStatic

class ClassInitParser : ParserStatic(
        KeywordStatic("new"),
        FunctionCallParser()
) {
}