package unify.parsers.comments

import language.parsers.Parser
import lib.matcher.sections.*
import unify.parsers.operators.SCommentOperatorParser
import unify.tokens.characters.NewLine
import unify.tokens.characters.Space
import unify.tokens.characters.Tab

class SingleLineCommentParser : Parser(
        ZeroOrManySection(
                AlternativeSection(
                        NewLine,
                        Space,
                        Tab
                )
        ),
        SCommentOperatorParser(),
        ZeroOrManySection(
                NotSection(
                        NewLine
                )
        ),
        name = "SINGLE_LINE_COMMENT"
)

