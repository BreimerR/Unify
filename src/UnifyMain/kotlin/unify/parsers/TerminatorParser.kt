package unify.parsers

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.EndsWithSection
import unify.tokens.characters.NewLine
import unify.tokens.characters.SColon


@Deprecated("Use: TerminatorParserPartial")
class TerminatorParser : ParserStatic(
        AlternativeSection(
                SColon,
                EndsWithSection(NewLine, considerSeparation = true)
        )
)