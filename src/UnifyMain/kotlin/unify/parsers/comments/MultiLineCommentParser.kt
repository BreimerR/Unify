package unify.parsers.comments

import language.parsers.Parser
import lib.matcher.sections.NotSection
import lib.matcher.sections.ZeroOrManySection
import unify.parsers.operators.MlCommentEndOperatorParser
import unify.parsers.operators.MlCommentStartOperatorParser

class MultiLineCommentParser : Parser(
        MlCommentStartOperatorParser(),
        ZeroOrManySection(
                NotSection(
                        MlCommentEndOperatorParser()
                )
        ),
        MlCommentEndOperatorParser(),
        name = "MULTILINE_COMMENT"
) {
    override val considerSpaces = false
}