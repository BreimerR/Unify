package unify.parsers.headers

import language.parsers.ParserStatic
import language.sections.OptionalSection
import unify.parsers.TypeDeclarationParser
import unify.parsers.TypeInitializationParser
import unify.tokens.characters.At
import unify.tokens.characters.LBracket
import unify.tokens.characters.RBracket
import unify.tokens.strings.Identifier


class AnnotationParser : ParserStatic(
    At,
    TypeDeclarationParser(),
    OptionalSection(
        AnnotationArgumentsParser()
    )
)