package unify.parsers.comments

import language.parsers.ParserStatic
import language.sections.AlternativeSection

class CommentsParser : ParserStatic(
        AlternativeSection(
                SingleLineComment(),
                MultiLineComment()
        )
) {
}