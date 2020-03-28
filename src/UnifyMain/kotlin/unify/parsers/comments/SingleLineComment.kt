package unify.parsers.comments

import language.parsers.AlternativeParser
import language.parsers.ParserStatic
import language.sections.EndsWithSection
import language.sections.PassiveSection
import language.sections.Section
import unify.tokens.characters.FSlash
import unify.tokens.characters.NewLine
import unify.tokens.tokens.EOF

// never collect EOF
class SingleLineComment : ParserStatic(
        FSlash,
        FSlash,
        // ends with error causing single line comment not to terminate
        EndsWithSection(
                AlternativeParser(
                        Section(
                                NewLine,
                                considerNewLine = true
                        ),
                        PassiveSection(EOF)
                )
        )
)
