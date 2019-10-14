package unify.parsers.operators

import language.parsers.Parser
import lib.matcher.sections.Section
import unify.tokens.characters.FSlash

class SCommentOperatorParser : Parser(
        Section(
                FSlash,
                FSlash
        ),
        name = "SINGLE_COMMENT_START"
)