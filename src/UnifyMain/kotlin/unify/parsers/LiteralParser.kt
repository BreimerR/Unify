package unify.parsers

import language.parsers.Parser
import language.sections.AlternativeSection

class LiteralParser : Parser(
        AlternativeSection(
                ReferenceParser(),
                NumberParser()/*,
                StringParser(),
                ArrayParser()*/
        )
)