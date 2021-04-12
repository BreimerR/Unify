package unify.parsers.expressions

import language.parsers.ParserStatic
import language.sections.OptionalSection
import language.sections.Section
import unify.parsers.ParametersParser
import unify.parsers.GenericTypeParser
import unify.parsers.functions.FuncExceptionParser
import unify.parsers.functions.FunctionReturnParser
import unify.tokens.strings.Identifier

class FunctionStartParser : ParserStatic(
        OptionalSection(
                GenericTypeParser()
        ),
        // function name
        Section(Identifier),
        // function arguments
        ParametersParser(),
        OptionalSection(
                FunctionReturnParser()
        ),
        OptionalSection(
                // thrown error
                FuncExceptionParser()
        )
) {
    override val TAG = "FunctionStartParser"
}