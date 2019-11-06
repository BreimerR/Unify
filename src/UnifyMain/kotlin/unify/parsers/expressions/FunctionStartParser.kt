package unify.parsers.expressions

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.OptionalSection
import language.sections.Section
import unify.parsers.ArgumentsParser
import unify.parsers.GenericTypeParser
import unify.parsers.TypeInitializationParser
import unify.tokens.characters.Colon
import unify.tokens.strings.Identifier
import unify.tokens.strings.KeywordStatic

class FunctionStartParser : ParserStatic(
        OptionalSection(
                GenericTypeParser()
        ),
        // function name
        Section(Identifier),
        // function arguments
        ArgumentsParser(),
        // return type
        OptionalSection(
                OptionalSection(
                        AlternativeSection(
                                Colon,
                                KeywordStatic("returns")
                        )
                ),
                TypeInitializationParser()
        ),
        // throw an error
        OptionalSection(
                KeywordStatic("throws"),
                Identifier
        )
)