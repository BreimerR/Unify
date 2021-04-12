package unify.parsers.comments

import language.parsers.ParserStatic
import language.sections.AlternativeSection

class CommentsParser : ParserStatic(
        AlternativeSection(
                // TODO comment does not end correctly
                SingleLineComment(),
                MultiLineComment()
        )
) {
        override val TAG = "CommentsParser"
}