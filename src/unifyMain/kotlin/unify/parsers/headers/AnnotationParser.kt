package unify.parsers.headers

import language.parsers.ParserStatic
import language.sections.OptionalSection
import unify.tokens.characters.At
import unify.tokens.characters.LBracket
import unify.tokens.characters.RBracket
import unify.tokens.strings.Identifier


class AnnotationParser : ParserStatic(
    At,
    Identifier,
    OptionalSection(
        LBracket,
        RBracket
    )
)