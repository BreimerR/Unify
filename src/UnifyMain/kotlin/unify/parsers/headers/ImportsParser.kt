package unify.parsers.headers

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.OptionalSection
import language.sections.ZeroOrMany
import unify.parsers.TerminatorParser
import unify.tokens.characters.Dot
import unify.tokens.strings.Identifier
import unify.tokens.strings.IdentifierStatic
import unify.tokens.strings.Keyword

class ImportsParser : ParserStatic(
        ZeroOrMany(
                IdentifierStatic("import"),
                ZeroOrMany(
                        AlternativeSection(
                                Identifier,
                                Keyword
                        ),
                        Dot
                ),
                AlternativeSection(
                        Identifier
                ),
                OptionalSection(
                        IdentifierStatic("as"),
                        Identifier
                ),
                TerminatorParser()
        )
)

