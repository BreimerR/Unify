package unify.parsers

import language.sections.Section
import language.parsers.ParserStatic
import unify.tokens.strings.Identifier
import unify.tokens.strings.KeywordStatic

class FunctionParser : ParserStatic(
        Section(
                KeywordStatic("func"),
                Identifier,
                ArgumentParser(),
                FunctionBodyParser(),
                considerSeparation = false
        ),
        considerSeparation = false
)