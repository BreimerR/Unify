package unify.parsers.comments

import language.parsers.ParserStatic
import language.sections.EndsWithSection
import unify.tokens.characters.Asterisk
import unify.tokens.characters.FSlash

class MultiLineComment : ParserStatic(
        FSlash, Asterisk,
        EndsWithSection(Asterisk, FSlash, considerSeparation = true)
)
