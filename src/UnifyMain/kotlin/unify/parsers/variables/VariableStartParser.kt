package unify.parsers.variables

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.Section
import unify.parsers.TypeInitializationParser
import unify.tokens.strings.Identifier

class VariableStartParser : ParserStatic(
        AlternativeSection(
                Section(TypeInitializationParser(), Identifier),
                Section(Identifier)
        )
) {
    override val TAG = "VariableStartParser"
}