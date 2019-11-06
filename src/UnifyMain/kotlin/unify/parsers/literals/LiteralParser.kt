package unify.parsers.literals

import language.parsers.ParserStatic
import language.sections.AlternativeSection

class LiteralParser : ParserStatic(
        AlternativeSection(
                ReferenceParser(),
                NumberParser(),
                ArrayParser()
        )
)