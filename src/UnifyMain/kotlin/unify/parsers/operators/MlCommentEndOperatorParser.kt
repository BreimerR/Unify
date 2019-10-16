package unify.parsers.operators

import language.parsers.Parser
import language.sections.Section

import unify.tokens.characters.Asterisk
import unify.tokens.characters.FSlash

class MlCommentEndOperatorParser : Parser(
        Section(
                Asterisk,
                FSlash,
                considerSpaces = false
        ),
        name = "MULTILINE_COMMENT_END"
)