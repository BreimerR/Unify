package unify.parsers.literals

import language.parsers.AlternativeParser
import language.parsers.ParserStatic
import language.sections.AlternativeSection

class LiteralParser : AlternativeParser(
        ReferenceParser(),
        NumberParser(),
        ArrayParser()
)