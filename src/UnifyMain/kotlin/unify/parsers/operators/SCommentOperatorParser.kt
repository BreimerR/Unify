package unify.parsers.operators

import language.parsers.Parser
import language.sections.Section
import unify.tokens.characters.FSlash

class SCommentOperatorParser : Parser(
        Section(
                FSlash,
                FSlash,
                considerSpaces = true
        ),
        name = "SINGLE_COMMENT_START"
) {
    override val considerSpaces: Boolean
        get() = false
}