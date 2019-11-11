package unify.parsers.comments

import language.parsers.ParserStatic
import language.sections.*
import unify.tokens.characters.Asterisk
import unify.tokens.characters.FSlash
import unify.tokens.characters.NewLine
import unify.tokens.tokens.EOF

// never collect EOF
class SingleLineComment : ParserStatic(
        FSlash,
        FSlash,
        ZeroOrMany(
                NotSection(
                        AlternativeSection(
                                PassiveSection(EOF),
                                NewLine,
                                considerSeparation = true
                        )
                )
        )
)
