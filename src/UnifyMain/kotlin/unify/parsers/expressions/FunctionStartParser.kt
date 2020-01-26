package unify.parsers.expressions

import language.parsers.ParserStatic
import language.sections.OptionalSection
import language.sections.Section
import unify.parsers.ArgumentsParser
import unify.parsers.GenericTypeParser
import unify.parsers.functions.FuncExtensionsParser
import unify.tokens.strings.Identifier

class FunctionStartParser : ParserStatic(
        OptionalSection(
                GenericTypeParser()
        ),
        // function name
        Section(Identifier),
        // function arguments
        ArgumentsParser(),
        FuncExtensionsParser()
)