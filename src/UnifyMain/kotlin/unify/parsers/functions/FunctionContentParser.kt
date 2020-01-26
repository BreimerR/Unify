package unify.parsers.functions

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.OptionalSection
import language.sections.Section
import unify.parsers.ArgumentsParser
import unify.parsers.GenericTypeParser
import unify.parsers.TypeInitializationParser
import unify.parsers.expressions.FunctionStartParser
import unify.tokens.characters.Colon
import unify.tokens.strings.Identifier
import unify.tokens.strings.KeywordStatic

class FunctionContentParser : ParserStatic(
        FunctionStartParser(),
        // function body
        FunctionBodyParser()
)