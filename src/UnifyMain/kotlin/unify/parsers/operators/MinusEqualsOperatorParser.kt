package unify.parsers.operators

import language.parsers.Parser
import lib.matcher.sections.Section
import unify.tokens.characters.Equals
import unify.tokens.characters.Minus


class MinusEqualsOperatorParser : Parser(
        Section(
                Minus,
                Equals
        ),
        name = "MINUS_EQUALS_OPERATOR"
) {

}