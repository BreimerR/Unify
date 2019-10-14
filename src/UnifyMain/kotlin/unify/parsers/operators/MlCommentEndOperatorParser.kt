package unify.parsers.operators

import language.parsers.Parser
import lib.matcher.sections.Section
import unify.tokens.characters.Asterisk
import unify.tokens.characters.FSlash

class MlCommentEndOperatorParser : Parser(
        Section(
                Asterisk,
                FSlash
        ),
        name = "MULTILINE_COMMENT_END"
)