package unify.parsers.operators

import language.parsers.Parser
import language.sections.Section
import unify.tokens.characters.Asterisk
import unify.tokens.characters.FSlash

class MlCommentStartOperatorParser : Parser(
        Section(
                FSlash,
                Asterisk,
                considerSpaces = true
        ),
        name = "MULTILINE_COMMENT_START",
        considerSpaces = false
)