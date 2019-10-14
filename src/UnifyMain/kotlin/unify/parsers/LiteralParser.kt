package unify.parsers

import language.parsers.Parser
import lib.matcher.sections.AlternativeSection

class LiteralParser : Parser(
        AlternativeSection(
                ReferenceParser(),
                NumberParser()/*,
                StringParser(),
                ArrayParser()*/
        )
)