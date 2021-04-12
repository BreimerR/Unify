package unify.parsers

import language.parsers.AlternativeParser
import language.parsers.ParserStatic
import language.sections.PassiveSection
import language.sections.Section
import unify.tokens.characters.NewLine
import unify.tokens.characters.SColon
import unify.tokens.tokens.EOF

class TerminatorParser : ParserStatic(
        // structure of the alternative parser is important else the termination will not work
        AlternativeParser(
                SColon,
                Section(
                        NewLine,
                        considerNewLines = true
                ),
                PassiveSection(EOF)
        )
) {
    override val TAG = "TerminatorParser"
}