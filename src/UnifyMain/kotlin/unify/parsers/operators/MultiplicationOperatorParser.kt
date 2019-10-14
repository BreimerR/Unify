package unify.parsers.operators

import language.parsers.Parser
import lib.matcher.sections.Section
import unify.tokens.characters.Asterisk

class MultiplicationOperatorParser : Parser(
        Section(Asterisk),
        name = "MULTIPLICATION_OPERATOR"
) {

}