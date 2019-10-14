package unify.parsers.operators

import language.parsers.Parser
import lib.matcher.sections.Section
import unify.tokens.characters.Colon

class DColonOperatorParser : Parser(
        Section(Colon, Colon),
        name = "DOUBLE_COLON_OPERATOR"
)