package unify.parsers.variables

import language.parsers.ParserStatic
import language.sections.OptionalSection
import language.sections.RepetitiveBySection
import unify.parsers.MutableStateParser
import unify.tokens.characters.Coma
import unify.tokens.characters.LBrace
import unify.tokens.characters.RBrace

class ObjectDistractingParser : ParserStatic(
        LBrace,
        RepetitiveBySection(
                OptionalSection(
                        MutableStateParser()
                ),
                VariableStartParser(),
                VariableEndParser(),
                Coma
        ),
        RBrace
) {
    override val TAG = "ObjectDistractingParser"
}