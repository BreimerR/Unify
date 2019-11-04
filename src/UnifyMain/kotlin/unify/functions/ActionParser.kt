package unify.functions

import language.parsers.ParserStatic
import language.sections.Section
import unify.tokens.strings.Identifier
import unify.tokens.strings.KeywordStatic

class ActionParser : ParserStatic(
        KeywordStatic("act"),
        Section(Identifier),
        FunctionBodyParser()
) {
}