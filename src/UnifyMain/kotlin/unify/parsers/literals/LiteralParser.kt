package unify.parsers.literals

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import unify.parsers.expressions.ArrayParser

class LiteralParser : ParserStatic(
        AlternativeSection(
                ReferenceParser(),
                NumberParser(),
                ArrayParser()
        )
)