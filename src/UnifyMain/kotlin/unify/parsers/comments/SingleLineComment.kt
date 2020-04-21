package unify.parsers.comments

import language.parsers.ParserStatic
import language.sections.AlternativeSection
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
                AlternativeSection(
                        Section(
                                NewLine,
                                considerNewLines = true
                        ),
                        PassiveSection(EOF)
                )
        )
) {
    override val TAG = "SingleLineComment"
}
