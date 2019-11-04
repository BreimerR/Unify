package unify.functions

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.OptionalSection
import language.sections.Section
import unify.parsers.ArgumentsParser
import unify.parsers.TypeInitializationParser
import unify.tokens.strings.Identifier
import unify.tokens.strings.KeywordStatic

class FunctionParser : ParserStatic(
        Section(KeywordStatic("func")),
        FunctionContentParser()
)