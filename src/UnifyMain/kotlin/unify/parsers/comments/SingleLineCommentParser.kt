package unify.parsers.comments

import language.parsers.Parser
import language.sections.NotSection
import language.sections.Section
import language.sections.ZeroOrManySection
import unify.parsers.operators.SCommentOperatorParser
import unify.tokens.characters.NewLine
import unify.tokens.characters.Space
import unify.tokens.characters.Tab

class SingleLineCommentParser : Parser(
        SCommentOperatorParser(),
        ZeroOrManySection(
                // ont section taking too long
                NotSection(
                        NewLine,
                        considerSpaces = true
                ),
                considerSpaces = true
        ),
        Section(NewLine, considerSpaces = true),
        name = "SINGLE_LINE_COMMENT",
        considerSpaces = false
)

