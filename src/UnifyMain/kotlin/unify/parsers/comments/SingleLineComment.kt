package unify.parsers.comments

import language.parsers.ParserStatic
import language.sections.EndsWithSection
import unify.tokens.characters.FSlash
import unify.tokens.characters.NewLine

// never collect EOF
class SingleLineComment : ParserStatic(
        FSlash,
        FSlash,
        EndsWithSection(NewLine, considerSeparation = true)
)
