package unify.parsers.functions

import language.parsers.ParserStatic
import language.sections.OptionalSection
import language.sections.Section
import unify.parsers.ArgumentsParser
import unify.parsers.GenericTypeParser
import unify.parsers.TypeInitializationParser
import unify.tokens.characters.Colon
import unify.tokens.strings.Identifier
import unify.tokens.strings.KeywordStatic

class FunctionContentParser : ParserStatic(
        OptionalSection(
                GenericTypeParser()
        ),
        // function name
        Section(Identifier),
        // function arguments
        ArgumentsParser(),
        // return type
        OptionalSection(
                Colon,
                TypeInitializationParser()
        ),
        // throw an error
        OptionalSection(
                KeywordStatic("throws"),
                Identifier
        ),
        // function body
        FunctionBodyParser()
)