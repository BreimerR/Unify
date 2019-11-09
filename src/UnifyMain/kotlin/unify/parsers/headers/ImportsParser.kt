package unify.parsers.headers

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.OptionalSection
import language.sections.Section
import language.sections.ZeroOrMany
import unify.parsers.TerminatorParser
import unify.tokens.characters.Dot
import unify.tokens.strings.Identifier
import unify.tokens.strings.IdentifierStatic
import unify.tokens.strings.Keyword
import unify.tokens.strings.KeywordStatic

class ImportsParser : ParserStatic(
        ZeroOrMany(
                IdentifierStatic("import"),
                AlternativeSection(
                        Section(
                                ZeroOrMany(
                                        AlternativeSection(
                                                Identifier,
                                                Keyword
                                        ),
                                        Dot
                                ),
                                Identifier
                        ),
                        Identifier
                ),
                OptionalSection(
                        KeywordStatic("as"),
                        Identifier
                ),
                TerminatorParser()
        )
)