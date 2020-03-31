package unify.parsers.variables

import language.parsers.ParserStatic
import language.sections.OptionalSection
import unify.parsers.MutableStateParser
import unify.tokens.strings.KeywordStatic

class MutableVariableDeclarationParser : ParserStatic(
        // define if the var or val is static
        OptionalSection(
                // if true this value should be available
                KeywordStatic("const")
        ),
        MutableStateParser(),
        SimpleVariableParser()
) {
    override val TAG = "VariableDeclaration"
}