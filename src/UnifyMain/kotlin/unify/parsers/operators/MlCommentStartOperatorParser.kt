package unify.parsers.operators

import language.parsers.Parser
import lib.matcher.sections.Section
import unify.tokens.characters.Asterisk
import unify.tokens.characters.FSlash

class MlCommentStartOperatorParser : Parser(
        Section(
                FSlash,
                Asterisk
        ),
        name = "MULTILINE_COMMENT_START"
)