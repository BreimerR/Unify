package unify.parsers.functions

import language.parsers.ParserStatic
import language.sections.OptionalSection
import language.sections.Section
import unify.parsers.headers.AnnotationParser
import unify.tokens.strings.KeywordStatic

class FunctionParser : ParserStatic(
    OptionalSection(
        AnnotationParser()
    ),
    Section(
        KeywordStatic("func")
    ),
    FunctionContentParser()
) {
    override val TAG = "FunctionParser"
}

