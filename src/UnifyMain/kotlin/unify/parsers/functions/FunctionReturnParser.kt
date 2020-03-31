package unify.parsers.functions

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import unify.parsers.TypeInitializationParser
import unify.tokens.characters.Colon
import unify.tokens.strings.KeywordStatic

class FunctionReturnParser : ParserStatic(
        AlternativeSection(
                Colon,
                KeywordStatic("returns")
        ),
        TypeInitializationParser()
) {
    override val TAG = "FunctionReturnParser"
}
