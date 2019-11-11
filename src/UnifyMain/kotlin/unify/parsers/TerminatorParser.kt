package unify.parsers

import language.sections.AlternativeSection
import language.parsers.ParserStatic
import language.sections.ZeroOrMany
import language.sections.NotSection
import language.sections.Section
import unify.tokens.characters.NewLine
import unify.tokens.characters.SColon
import unify.tokens.characters.Space
import unify.tokens.characters.Tab

class TerminatorParser : ParserStatic(
        AlternativeSection(
                SColon,
                Section(
                        ZeroOrMany(
                                NotSection(
                                        AlternativeSection(
                                                Tab,Space,considerSeparation = true
                                        )
                                )
                        ),
                        AlternativeSection(
                                NewLine,
                                considerSeparation = true
                        )
                )
        )
)