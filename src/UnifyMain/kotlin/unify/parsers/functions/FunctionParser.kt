package unify.parsers.functions

import language.parsers.ParserStatic
import language.sections.Section
import unify.tokens.strings.KeywordStatic

class FunctionParser : ParserStatic(
        Section(
                KeywordStatic("func")
        ),
        FunctionContentParser()
) {
    override val TAG = "FunctionParser"
}