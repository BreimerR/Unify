package unify.parsers.literals

import language.parsers.ParserStatic
import language.sections.AlternativeSection

class LiteralParser : ParserStatic(
        AlternativeSection(
                StringParser(),
                CharacterParser(),
                ReferenceParser(),
                NumberParser(),
                ArrayParser()
        )
) {
    override val TAG = "LiteralParser"
}