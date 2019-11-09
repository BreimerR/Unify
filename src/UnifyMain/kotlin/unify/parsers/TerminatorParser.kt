package unify.parsers

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.Section
import language.sections.ZeroOrMany
import unify.tokens.characters.NewLine
import unify.tokens.characters.SColon
import unify.tokens.characters.Space
import unify.tokens.characters.Tab

class TerminatorParser : ParserStatic(
        AlternativeSection(
                SColon,
                Section(
                        ZeroOrMany(
                                AlternativeSection(
                                        Tab, Space
                                )
                        ),
                        NewLine,
                        considerSeparation = true
                )
        )
)