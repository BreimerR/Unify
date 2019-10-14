package unify.parsers

import language.parsers.Parser
import lib.matcher.sections.Section
import unify.tokens.characters.Dot
import unify.tokens.strings.Identifier

class BreakDownArgumentParser : Parser(
        Section(Dot, Dot, Dot),
        Section(Identifier, name = "NAME"),
        name = "BREAKDOWN_ARGUMENT_PARSER"
) {
}