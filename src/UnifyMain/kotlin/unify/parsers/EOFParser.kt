package unify.parsers

import language.parsers.Parser
import lib.matcher.sections.Section
import unify.tokens.tokens.EOF

class EOFParser : Parser(
        Section(EOF, name = "end"),
        name = "End Of File"
) {
    override val considerSpaces = false
}