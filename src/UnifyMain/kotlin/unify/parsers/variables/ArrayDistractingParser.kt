package unify.parsers.variables

import language.parsers.ParserStatic
import language.sections.OptionalSection
import language.sections.RepetitiveBySection
import unify.parsers.MutableStateParser
import unify.tokens.characters.Coma
import unify.tokens.characters.LSBracket
import unify.tokens.characters.RSBracket

class ArrayDistractingParser : ParserStatic(
        LSBracket,
        RepetitiveBySection(
                OptionalSection(
                        MutableStateParser()
                ),
                VariableStartParser(),
                VariableEndParser(),
                Coma
        ),
        RSBracket
) {
    override val TAG = "ArrayDistractingParser"
}