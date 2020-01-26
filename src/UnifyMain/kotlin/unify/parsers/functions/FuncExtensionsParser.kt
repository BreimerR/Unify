package unify.parsers.functions

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.OptionalSection
import unify.parsers.TypeInitializationParser
import unify.parsers.functions.FuncExceptionParser
import unify.tokens.characters.Colon
import unify.tokens.strings.KeywordStatic

class FuncExtensionsParser : ParserStatic(
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
      FuncExceptionParser()
)
