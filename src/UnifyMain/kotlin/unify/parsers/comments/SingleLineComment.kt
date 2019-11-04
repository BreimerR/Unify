package unify.parsers.comments

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.EndsWithSection
import language.sections.NotSection
import language.sections.ZeroOrMany
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
                        AlternativeSection(EOF, NewLine)
                )
        )
)
