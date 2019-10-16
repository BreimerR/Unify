package unify.parsers

import language.parsers.Parser
import language.sections.AlternativeSection
import language.sections.Section
import language.sections.ZeroOrManySection
import unify.tokens.characters.NewLine
import unify.tokens.characters.Space
import unify.tokens.characters.Tab
import unify.tokens.tokens.EOF

class EOFParser : Parser(
        ZeroOrManySection(
                AlternativeSection(
                        NewLine,
                        Tab,
                        Space,
                        considerSpaces = true
                ),
                considerSpaces = true
        ),
        Section(EOF, name = "end", considerSpaces = true),
        name = "End Of File",
        considerSpaces = false
)