package unify.parsers.comments


import language.parsers.Parser
import language.sections.AlternativeSection
import language.sections.NotSection
import language.sections.ZeroOrManySection
import unify.parsers.EOFParser
import unify.parsers.operators.MlCommentEndOperatorParser
import unify.parsers.operators.MlCommentStartOperatorParser

class MultiLineCommentParser : Parser(
        MlCommentStartOperatorParser(),
        ZeroOrManySection(
                NotSection(
                        AlternativeSection(
                                MlCommentEndOperatorParser(),
                                EOFParser(),
                                considerSpaces = false
                        ),
                        considerSpaces = false
                ),
                considerSpaces = false
        ),
        MlCommentEndOperatorParser(),
        name = "MULTILINE_COMMENT",
        considerSpaces = false
)