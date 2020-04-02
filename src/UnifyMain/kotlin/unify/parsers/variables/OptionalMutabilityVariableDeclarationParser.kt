package unify.parsers.variables

import language.parsers.ParserStatic
import language.sections.OptionalSection
import unify.parsers.MutableStateParser

class OptionalMutabilityVariableDeclarationParser : ParserStatic(
        OptionalSection(
                MutableStateParser()
        ),
        SimpleVariableParser()
) {
    override val TAG = "OptionalMutabilityVariableDeclarationParser"
}