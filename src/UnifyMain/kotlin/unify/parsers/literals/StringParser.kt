package unify.parsers.literals

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.NotSection
import language.sections.ZeroOrMany
import unify.tokens.characters.DQuotes

class StringParser : ParserStatic(
        DQuotes,
        ZeroOrMany(
                AlternativeSection(
                        EScapeCharacter(DQuotes, considerSpaces = true),
                        NotSection(
                                DQuotes,
                                considerSeparation = true
                        ),
                        considerSeparation = true
                )
        ),
        DQuotes

)


